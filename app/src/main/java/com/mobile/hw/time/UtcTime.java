package com.mobile.hw.time;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/19/15
 * Time: 2:59 PM
 * <p/>
 * 描述时区？
 */

public class UtcTime extends TimeSubject {

    @Override
    public void notifyAllClocks() {
        for (Clock clock : clocks.values()) {
            clock.setLocalTime(Clock.toLocaleTime(this.utcZeroTime));
        }
    }
}
