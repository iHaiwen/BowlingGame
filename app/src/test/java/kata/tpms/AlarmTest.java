package kata.tpms;

import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Created by benwu on 14-6-10.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class AlarmTest {
    @Test
    public void a_trivial_test() {
        assertEquals(5, 2 + 3);
    }

    @Test
    public void aNormalPressureValueShouldNotRaiseTheAlarm() {
        //Arrange
        StubSensor stubSensor = new StubSensor();
        stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD);
        Alarm alarm = new Alarm(stubSensor);

        //Act
        alarm.check();

        //Assert
        Assert.assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void aPressureValueOutsideTheRangeShouldRaiseTheAlarm() throws Exception {
        //Arrange
        StubSensor stubSensor = new StubSensor();
        stubSensor.arrangeNextPressurePsiValue(Alarm.HIGH_PRESSURE_THRESHOLD + 1);
        Alarm alarm = new Alarm(stubSensor);

        //Act
        alarm.check();

        //Assert
        Assert.assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void aNormalPressureValueAfterAValueOutsideTheRangeShouldStopTheAlarm() throws Exception {
        //Arrange
        StubSensor stubSensor = new StubSensor();
        Alarm alarm = new Alarm(stubSensor);

        //Act
        stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD - 1);
        alarm.check();

        stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD);
        alarm.check();

        //Assert
        Assert.assertFalse(alarm.isAlarmOn());
    }
}
