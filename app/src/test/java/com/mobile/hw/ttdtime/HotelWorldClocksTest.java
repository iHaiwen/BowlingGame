package com.mobile.hw.ttdtime;

import com.mobile.hw.bowlinggame.BuildConfig;

import junit.framework.Assert;

import org.junit.Before;
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

    private HotelWorldClockSystem hotelWorldClockSystem;
    private PhoneClock phoneClock;

    @Before
    public void initialize() throws Exception {
        this.hotelWorldClockSystem = new HotelWorldClockSystem();
        this.phoneClock = new PhoneClock(8);
    }

    @Test
    public void theTimeOfClockLondonShouldBe1AfterThePhoneClockIsSetTo9BeijingTime() {
        //Arrange
        CityClock londonClock = new CityClock(0);
        hotelWorldClockSystem.attach(londonClock);
        //Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);
        //Assert
        Assert.assertEquals(1, londonClock.getTime());
    }

    @Test
    public void theTimeOfClockNewYorkShouldBe20AfterThePhoneClockIsSetTo9BeijingTime() {
        //Arrange
        CityClock newYorkClock = new CityClock(-5);
        hotelWorldClockSystem.attach(newYorkClock);

        //Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(20, newYorkClock.getTime());
    }

    @Test
    public void theTimeOfClockLondonAndNewYorkShouldBe1And20RespectivelyAfterThePhoneClockIsSetTo9BeijingTime() {
        //
        CityClock londonClock = new CityClock(0);
        CityClock newYorkClock = new CityClock(-5);
        hotelWorldClockSystem.attach(londonClock);
        hotelWorldClockSystem.attach(newYorkClock);

        //Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(1, londonClock.getTime());
        Assert.assertEquals(20, newYorkClock.getTime());
    }

    @Test
    public void theTimeOfThePhoneClockShouldBeSetCorrectlyAfterItsSetTimeMethodInvoked() {
        //Arrange
        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(9, phoneClock.getTime());
    }

    @Test
    public void theTimeOfClockMoscowShouldBe5AfterThePhoneClockIsSetTo9BeijingTime() {
        //Arrange
        CityClock moscowYorkClock = new CityClock(4);
        hotelWorldClockSystem.attach(moscowYorkClock);

        //Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(5, moscowYorkClock.getTime());
    }
}
