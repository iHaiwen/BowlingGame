package kata.td;

/**
 * Author: haiwen.li
 * Time: 8/26/15 11:39 PM
 * <p/>
 * Mock Turn number的生成
 */

public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;
    private int callsCount = 0;

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
    }

    //TODO-working-on: Finish the implementation of method MockTurnNumberSequence.
    public void verifyMethodGetNextTurnNumberCalledOne() {
        if (this.callsCount != 1) {
            throw new IllegalStateException("The method getNextTurnNumber() should called once.");
        }
    }

    @Override
    public int getNextTurnNumber() {
        return this.nextTurnNumber;
    }
}
