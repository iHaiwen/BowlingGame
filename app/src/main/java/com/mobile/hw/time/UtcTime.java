package com.mobile.hw.time;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/19/15
 * Time: 2:59 PM
 * <p/>
 * 描述时区？
 */

class UtcTime extends TimeSubject {

    private int utcZeroTime;

    @Override
    public void notifyAllClocks() {
        for (Clock clock : clocks.values()) {
            clock.setLocalTime(Clock.toLocaleTime(this.utcZeroTime));
        }
    }

    public int getUtcZeroTime() {
        return utcZeroTime;
    }

    public void setUtcZeroTime(int utcZeroTime) {
        this.utcZeroTime = utcZeroTime;
        notifyAllClocks();
    }
}
