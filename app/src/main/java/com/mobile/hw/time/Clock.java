package com.mobile.hw.time;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/19/15
 * Time: 2:53 PM
 * <p/>
 * 时钟类
 */

abstract class Clock {

    protected static final int UTC_OFFSET = 0;
    protected int localTime = 0;
    protected UtcTime utcTime;

    public abstract void setLocalTime(int localTime);

    public static int toLocaleTime(int utcZeroTime) {
        return utcZeroTime + UTC_OFFSET;
    }
}
