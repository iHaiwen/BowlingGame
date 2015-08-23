package com.mobile.hw.ttdtime;

/**
 * Author: haiwen.li
 * Time: 8/23/15 8:09 PM
 * <p/>
 * 描述一个时钟
 */

public abstract class Clock {
    protected int utcOffset;

    public abstract int getTime();
}
