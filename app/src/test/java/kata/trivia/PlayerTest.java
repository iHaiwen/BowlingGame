package kata.trivia;

import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

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
    public void theCategoryShouldBePopIfThePlayerInPlace0Or4Or8() {
        //Arrange
        Player player = new Player("Ben");
        String category = "Pop";

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
        //Arrange
        Player player = new Player("Ben");
        String category = "Science";

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
        //Arrange
        Player player = new Player("Ben");
        String category = "Sports";

        //Act, Assert
        player.moveForwardSteps(2);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());
    }

    public void theCategoryShouldBeRockIfThePlayerInPlace3Or7Or11() {
        //Arrange
        Player player = new Player("Ben");
        String category = "Rock";

        //Act, Assert
        player.moveForwardSteps(3);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        Assert.assertEquals(category, player.getCurrentCategory());
    }
}
