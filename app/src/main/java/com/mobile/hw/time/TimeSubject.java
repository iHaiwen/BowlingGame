package com.mobile.hw.time;

import java.util.HashMap;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/19/15
 * Time: 2:39 PM
 * <p/>
 * TODO: Add a header comment!
 */

public abstract class TimeSubject {

    protected final HashMap<String, Clock> clocks = new HashMap<>();

    public void attach(String cityName, Clock clock) {
        clocks.put(cityName, clock);
    }

    public void detach(String cityName) {
        clocks.remove(cityName);
    }

    public abstract void notifyAllClocks();
}
