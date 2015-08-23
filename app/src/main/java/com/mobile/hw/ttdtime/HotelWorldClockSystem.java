package com.mobile.hw.ttdtime;

import java.util.ArrayList;

/**
 * Author: haiwen.li
 * Time: 8/21/15 3:36 PM
 * <p/>
 * 关联多个时区时钟
 */

public class HotelWorldClockSystem {

    private ArrayList<CityClock> cityClocks = new ArrayList<>();

    public void attach(CityClock cityClock) {

    }

    public ArrayList<CityClock> getClocks() {
        return this.cityClocks;
    }
}
