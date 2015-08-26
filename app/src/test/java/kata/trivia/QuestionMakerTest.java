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

    private QuestionMaker questionMaker;

    @Before
    public void initialize() throws Exception {
        //Arrange
        questionMaker = new QuestionMaker();
    }

    @Test
    public void addTwoPopQuestionAndCouldRemoveTheFirstOne() {
        //Act
        questionMaker.addPopQuestion("Pop Question 1");
        questionMaker.addPopQuestion("Pop Question 2");
        //Assert
        Assert.assertEquals("Pop Question 1", questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void addTwoScienceQuestionsAndCouldRemoveTheFirstOne() {
        //Act
        questionMaker.addScienceQuestion("Science Question 1");
        questionMaker.addScienceQuestion("Science Question 2");
        //Assert
        Assert.assertEquals("Science Question 1", questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void addTwoSportsQuestionsAndCouldRemoveTheFirstOne() {
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
}
