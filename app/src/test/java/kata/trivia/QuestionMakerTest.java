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
        //Act, Assert
        Assert.assertEquals("Pop Question 0", questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void addTwoScienceQuestionsAndCouldRemoveTheFirstOne() {
        //Act, Assert
        Assert.assertEquals("Science Question 0", questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void addTwoSportsQuestionsAndCouldRemoveTheFirstOne() {
        //Act, Assert
        Assert.assertEquals("Sports Question 0", questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void addTwoRockQuestionsAndCouldRemoveTheFirstOne() {
        //Act, Assert
        Assert.assertEquals("Rock Question 0", questionMaker.removeFirstRockQuestion());
    }
}
