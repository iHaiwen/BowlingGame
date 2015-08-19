package com.mobile.hw.time;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/19/15
 * Time: 2:53 PM
 * <p/>
 * 时钟类
 */

public abstract class Clock {

    private static final int UTC_OFFSET = 0;
    private int localTime = 0;

    public abstract void setLocalTime(int localTime);

    public static int toLocaleTime(int utcZeroTime) {
        return utcZeroTime + UTC_OFFSET;
    }
}
