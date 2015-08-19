package com.mobile.hw.time;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/19/15
 * Time: 3:14 PM
 * <p/>
 * 手机时钟
 */

public class PhoneClock extends Clock {

    @Override
    public void setLocalTime(int localTime) {
        this.localTime = localTime;
        this.utcTime.setUtcZeroTime(localTime - UTC_OFFSET);
    }
}
