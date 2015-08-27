package kata.ufthtc;

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
public class UnicodeFileToHtmlTextConverterTest {
    @Test
    public void a_trivial_test() {
        assertEquals(5, 2 + 3);
    }

    //TODO-new-feature: Make the UnicodeFileToHtmlTextConverter working on for not only a file but also a string
}
