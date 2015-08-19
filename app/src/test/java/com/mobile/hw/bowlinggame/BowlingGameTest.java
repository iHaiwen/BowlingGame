package com.mobile.hw.bowlinggame;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created with Android Studio.
 * User: ihaiwen
 * Date: 6/30/15
 * Time: 10:05 AM
 * <p/>
 * TODO: Add a header comment!
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class BowlingGameTest {

    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    @Test
    public void testGutterGame() throws Exception {
        rollMany(0, 20);
        Assert.assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(1, 20);
        Assert.assertEquals(20, g.score());
    }

    private void rollMany(int pins, int roll) {
        for (int i = 0; i < roll; i++) {
            g.roll(pins);
        }
    }

    @Test
    public void testOneSqare() throws Exception {
        rollSqare();
        g.roll(3);
        rollMany(0, 17);
        Assert.assertEquals(16, g.score());
    }

    private void rollSqare() {
        g.roll(5);
        g.roll(5);//sqare
    }

    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(0, 16);
        Assert.assertEquals(24, g.score());
    }

    private void rollStrike() {
        g.roll(10); //strike
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(10, 12);
        Assert.assertEquals(300, g.score());
    }
}
