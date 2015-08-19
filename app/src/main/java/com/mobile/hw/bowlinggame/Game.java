package com.mobile.hw.bowlinggame;

/**
 * Created with Android Studio.
 * User: ihaiwen
 * Date: 7/23/15
 * Time: 9:59 AM
 * <p/>
 * TODO: Add a header comment!
 */

public class Game {

    private int[] rolls = new int[20];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSqare(frameIndex)) {
                score += 10 + sqareBonus(frameIndex);
                frameIndex += 2;
            } else if (isStrike(frameIndex)) {//strike
                score += 10 + strikeBonus(frameIndex);
                frameIndex += 1;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int sqareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSqare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
