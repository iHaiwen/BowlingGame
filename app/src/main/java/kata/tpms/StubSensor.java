package kata.tpms;

/**
 * Author: haiwen.li
 * Time: 8/26/15 3:54 PM
 * <p/>
 * stub sensor类
 */

public class StubSensor implements Transducer {

    private double nextPressurePsiValue;

    public void arrangeNextPressurePsiValue(double nextPressureThreshold) {
        this.nextPressurePsiValue = nextPressureThreshold;
    }

    @Override
    public double popNextPressurePsiValue() {
        return this.nextPressurePsiValue;
    }
}
