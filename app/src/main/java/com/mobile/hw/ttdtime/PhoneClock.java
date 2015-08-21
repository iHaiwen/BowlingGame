package com.mobile.hw.ttdtime;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/21/15
 * Time: 11:02 AM
 * <p/>
 * 描述手机的时间
 */

public class PhoneClock {

    private CityClock cityClock;
    private int utcOffset;

    public PhoneClock(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public void setCityClock(CityClock cityClock) {
        this.cityClock = cityClock;
    }

    public void setTime(int time) {
        this.cityClock.setUtcZeroTime(time - this.utcOffset);
    }
}
