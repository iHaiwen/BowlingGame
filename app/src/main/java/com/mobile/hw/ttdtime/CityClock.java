package com.mobile.hw.ttdtime;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/21/15
 * Time: 10:54 AM
 * <p/>
 * 描述某一城市的时间
 */

public class CityClock extends Clock {
    private int utcZeroTime;

    public CityClock(int utcOffset) {
        super.utcOffset = utcOffset;
    }

    public int getTime() {
        return (super.utcOffset + this.utcZeroTime + 24) % 24;
    }

    public void setUtcZeroTime(int utcZeroTime) {
        this.utcZeroTime = utcZeroTime;
    }
}
