package kata.trivia;

import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Author: haiwen.li
 * Time: 8/25/15 5:20 PM
 * <p/>
 * question maker的测试类
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class QuestionMakerTest {

    public static final String POP_QUESTION_1 = "Pop Question 1";
    public static final String SCIENCE_QUESTION_1 = "Science Question 1";
    public static final String SPORTS_QUESTION_1 = "Sports Question 1";
    public static final String ROCK_QUESTION_1 = "Rock Question 1";
    private QuestionMaker questionMaker;

    @Before
    public void initialize() throws Exception {
        //Arrange
        questionMaker = new QuestionMaker();
    }

    @Test
    public void addTwoPopQuestionAndCouldRemoveTheFirstOne() {
        //Act
        questionMaker.addPopQuestion(POP_QUESTION_1);
        questionMaker.addPopQuestion("Pop Question 2");
        //Assert
        Assert.assertEquals(POP_QUESTION_1, questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void addTwoScienceQuestionsAndCouldRemoveTheFirstOne() {
        //Act
        questionMaker.addScienceQuestion(SCIENCE_QUESTION_1);
        questionMaker.addScienceQuestion("Science Question 2");
        //Assert
        Assert.assertEquals(SCIENCE_QUESTION_1, questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void addTwoSportsQuestionsAndCouldRemoveTheFirstOne() {
        //Act
        questionMaker.addSportsQuestion(SPORTS_QUESTION_1);
        questionMaker.addSportsQuestion("Sports Question 2");
        //Assert
        Assert.assertEquals(SPORTS_QUESTION_1, questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void addTwoRockQuestionsAndCouldRemoveTheFirstOne() {
        //Arrange
        QuestionMaker questionMaker = new QuestionMaker();
        //Act
        questionMaker.addRockQuestion(ROCK_QUESTION_1);
        questionMaker.addRockQuestion("Rock Question 2");
        //Assert
        Assert.assertEquals(ROCK_QUESTION_1, questionMaker.removeFirstRockQuestion());
    }
}
