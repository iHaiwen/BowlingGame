package kata.trivia;


import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

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
    @Test
    public void theGameShouldBeOverIfAPlayerRollsTheDiceAndAnswersEachQuestionCorrectlyFor6Times() {
        //Arrange
        boolean isGameStillInProgress = true;
        Game game = new Game();
        game.add("Pet");
        //Act
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        //Assert
        Assert.assertFalse(isGameStillInProgress);
    }

    //TODO-user-intent: the game should be over if a player rolls the dice for 7 times and answers the question wrongly for 1 times followed by an odd rolling number but then correctly for 6 times
    @Test
    public void theGameShouldBeOverIfAPlayerRollsTheDiceFor7TimesAndAnswersTheQuestionWronglyFor1TimesFollowedByAnOddRollingNumberButThenCorrectlyFor6Times() {
        //Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;
        //Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(1);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 5; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }
        //Assert
        Assert.assertFalse(isGameStillInProgress);
    }

    //TODO-user-intent: the game should be over if a player rolls the dice for 8 times and answers the question wrongly for 1 times followed by an even rolling number but then correctly for 7 times
    @Test
    public void theGameShouldBeOverIfAPlayerRollsTheDiceFor8TimesAndAnswersTheQuestionWronglyFor1TimesFollowedByAnEvenRollingNumberButTheCorrectlyFor7TimesWithOddRollingNumbers() {
        //Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;
        //Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(2);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }
        //Assert
        Assert.assertFalse(isGameStillInProgress);
    }
}
