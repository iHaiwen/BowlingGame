package kata.trivia;


import com.mobile.hw.bowlinggame.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class GameTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertEquals(5, 2 + 3);
    }

    //TODO-user-intent: the game should be over if  a player rolls the dice and answers each question correctly for 6 times
    //TODO-user-intent: the game should be over if a player rolls the dice for 7 times and answers the question wrongly for 1 times followed by an odd rolling number but then correctly for 6 times
    //TODO-user-intent: the game should be over if a player rolls the dice for 8 times and answers the question wrongly for 1 times followed by an even rolling number but then correctly for 7 times

}
