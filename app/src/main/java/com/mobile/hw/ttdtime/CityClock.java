package com.mobile.hw.ttdtime;

/**
 * Created with Android Studio.
 * User: haiwen.li
 * Date: 8/21/15
 * Time: 10:54 AM
 * <p/>
 * 描述某一城市的时间
 */

public class CityClock {
    //TODO 构造函数和PhoneClock一样，重复了
    public CityClock(int utcOffset) {

    }

    //TODO-working-on 返回值写死
    public int getTime() {
        return this.utcOffset + this.utcZeroTime;
    }
}
