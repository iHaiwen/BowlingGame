package kata.td;

/**
 * Author: haiwen.li
 * Time: 8/26/15 11:39 PM
 * <p/>
 * Mock Turn number的生成
 */

public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
    }

    public void verifyMethodGetNextTurnNumberCalledOne() {

    }

    @Override
    public int getNextTurnNumber() {
        return this.nextTurnNumber;
    }
}
