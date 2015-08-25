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

    @Test
    public void addTwoPopQuestionAndCouldRemoveTheFirstOne() {
        //Arrange
        QuestionMaker questionMaker = new QuestionMaker();
        //Act
        questionMaker.addPopQuestion("Pop Question 1");
        questionMaker.addPopQuestion("Pop Question 2");
        //Assert
        Assert.assertEquals("Pop Question 1", questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void addTwoScienceQuestionsAndCouldRemoveTheFirstOne() {
        //Arrange
        QuestionMaker questionMaker = new QuestionMaker();
        //Act
        questionMaker.addScienceQuestion("Science Question 1");
        questionMaker.addScienceQuestion("Science Question 2");
        //Assert
        Assert.assertEquals("Science Question 1", questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void addTwoSportsQuestionsAndCouldRemoveTheFirstOne() {
        //Arrange
        QuestionMaker questionMaker = new QuestionMaker();
        //Act
        questionMaker.addSportsQuestion("Sports Question 1");
        questionMaker.addSportsQuestion("Sports Question 2");
        //Assert
        Assert.assertEquals("Sports Question 1", questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void addTwoRockQuestionsAndCouldRemoveTheFirstOne() {
        //Arrange
        QuestionMaker questionMaker = new QuestionMaker();
        //Act
        questionMaker.addRockQuestion("Rock Question 1");
        questionMaker.addRockQuestion("Rock Question 2");
        //Assert
        Assert.assertEquals("Rock Question 1", questionMaker.removeFirstRockQuestion());
    }

    @Test
    public void thePlaceShouldBe1IfThePlayerMovesForward1Step() {
        //Arrange
        Player player = new Player("Ben");

        //Act
        player.moveForwardSteps(1);

        //Assert
        Assert.assertEquals(1, player.getPlace());
    }

    @Test
    public void thePlaceShouldBe0IfThePlayerMovesForward12Steps() {
        //Arrange
        Player player = new Player("Ben");

        //Act
        player.moveForwardSteps(12);

        //Assert
        Assert.assertEquals(0, player.getPlace());
    }

    @Test
    public void theCategoryShouldBePopIfThePlayerMoves12Or4Or8Steps() {
        //Arrange
        Player player = new Player("Ben");
        String category = "Pop";

        //Act, Assert
        player.moveForwardSteps(12);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(8);
        Assert.assertEquals(category, player.getCurrentCategory());
    }

    //TODO-working-on: The category should be Science if the player moves 1, 5 or 9 steps
    @Test
    public void theCatgoryShouldBeScienceIfThePlayerMoves1Or5Or9Steps() {
        //Arrange
        Player player = new Player("Ben");
        String category = "Science";

        //Act, Assert
        player.moveForwardSteps(1);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(5);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(9);
        Assert.assertEquals(category, player.getCurrentCategory());
    }

    //TODO: The category should be Sports if the player moves 2, 6 or 10 steps
    //TODO: The category should be Rock if the player moves 3, 7 or 11 steps
}
