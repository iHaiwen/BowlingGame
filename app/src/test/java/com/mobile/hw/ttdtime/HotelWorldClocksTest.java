package com.mobile.hw.ttdtime;

import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/21/15
 * Time: 10:01 AM
 * <p/>
 * 用TDD方法来实现时钟功能编程
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class HotelWorldClocksTest {

    @Test
    public void theTimeOfClockLondonShouldBe1AfterThePhoneClockIsSetTo9BeijingTime() {
        //Arrange
        CityClock londonClock = new CityClock(0);
        PhoneClock phoneClock = new PhoneClock(8);
        //Act
        phoneClock.setCityClock(londonClock);
        phoneClock.setTime(9);
        //Assert
        Assert.assertEquals(1, londonClock.getTime());
    }
}
