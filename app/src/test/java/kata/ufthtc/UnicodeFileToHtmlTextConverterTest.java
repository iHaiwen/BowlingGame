package kata.ufthtc;

import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.io.StringReader;

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
    //TODO-user-intent-test-working-on: should convert ampersand
    @Test
    public void shouldConvertAmpersand() throws Exception {
        //Arrange
        UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(new StringReader("H&M"));
        //Act, Assert
        Assert.assertEquals("H&amp;M<br />", converter.convertToHtml());
    }

    @Test
    public void shouldConvertGreaterThanAndLessThan() throws Exception {
        //Arrange
        UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(new StringReader(">_<|||"));
        //Act, Assert
        Assert.assertEquals("&gt;_&lt;|||<br />", converter.convertToHtml());
    }

    //TODO-user-intent-test: should add a line break for new line
}
