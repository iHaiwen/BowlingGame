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
 * Time: 8/26/15 10:36 AM
 * <p/>
 * Player类的测试类
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class PlayerTest {

    private Player player;
    private String category = null;

    @Before
    public void initialize() throws Exception {
        //Arrange
        player = new Player("Ben");
    }

    @Test
    public void thePlaceShouldBe1IfThePlayerMovesForward1Step() {
        //Act
        player.moveForwardSteps(1);

        //Assert
        Assert.assertEquals(1, player.getPlace());
    }

    @Test
    public void thePlaceShouldBe0IfThePlayerMovesForward12Steps() {
        //Act
        player.moveForwardSteps(12);

        //Assert
        Assert.assertEquals(0, player.getPlace());
    }

    @Test
    public void theCategoryShouldBePopIfThePlayerInPlace0Or4Or8() {
        category = "Pop";

        //Act, Assert
        player.moveForwardSteps(12);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());
    }

    @Test
    public void theCategoryShouldBeScienceIfThePlayerInPlace1Or5Or9() {
        category = "Science";

        //Act, Assert
        player.moveForwardSteps(1);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());
    }

    @Test
    public void theCategoryShouldBeSportsIfThePlayerInPlace2Or6Or10() {
        category = "Sports";

        //Act, Assert
        player.moveForwardSteps(2);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());
    }

    public void theCategoryShouldBeRockIfThePlayerInPlace3Or7Or11() {
        category = "Rock";

        //Act, Assert
        player.moveForwardSteps(3);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());
    }
}
