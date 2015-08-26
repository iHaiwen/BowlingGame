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

    //TODO-user-intent-test-working-on: a pressure value outside the range should raise the alarm
    @Test
    public void aPressureValueOutsideTheRangeShouldRaiseTheAlarm() throws Exception {
        //Arrange
        StubSensor stubSensor = new StubSensor();
        stubSensor.arrangeNextPressurePsiValue(Alarm.HIGH_PRESSURE_THRESHHOLD + 1);
        Alarm alarm = new Alarm(stubSensor);

        //Act
        alarm.check();

        //Assert
        Assert.assertTrue(alarm.isAlarmOn());
    }

    //TODO-user-intent-test: a normal pressure after a value outside the range should not stop the alarm
    //TODO-new-feature: a normal pressure value after a value outside the range should stop the alarm
}
