package kata.tpms;

import com.mobile.hw.bowlinggame.BuildConfig;

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
}
