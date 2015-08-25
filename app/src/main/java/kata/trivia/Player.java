package kata.trivia;

/**
 * Author: haiwen.li
 * Time: 8/24/15 10:47 PM
 * <p/>
 * 描述一个玩家
 */

public class Player {

    public static final int MAX_NUMBER_OF_PLACE = 12;
    public static final int CATEGORY_POP_1 = 0;
    public static final int CATEGORY_POP_2 = 4;
    public static final int CATEGORY_POP_3 = 8;
    public static final int CATEGORY_SCIENCE_1 = 1;
    public static final int CATEGORY_SCIENCE_2 = 5;
    public static final int CATEGORY_SCIENCE_3 = 9;
    public static final int CATEGORY_SPORTS_1 = 2;
    public static final int CATEGORY_SPORTS_2 = 6;
    public static final int CATEGORY_SPORTS_3 = 10;

    private String playerName;
    private int place;
    private int sumOfGoldCoins = 0;
    private boolean isInInPenaltyBox = false;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return this.playerName;
    }

    public void moveForwardSteps(int steps) {
        this.place += steps;
        if (this.place > MAX_NUMBER_OF_PLACE - 1) {
            this.place -= MAX_NUMBER_OF_PLACE;
        }
    }

    public int getPlace() {
        return this.place;
    }

    public String getCurrentCategory() {
        if (this.place == CATEGORY_POP_1) return "Pop";
        if (this.place == CATEGORY_POP_2) return "Pop";
        if (this.place == CATEGORY_POP_3) return "Pop";
        if (this.place == CATEGORY_SCIENCE_1) return "Science";
        if (this.place == CATEGORY_SCIENCE_2) return "Science";
        if (this.place == CATEGORY_SCIENCE_3) return "Science";
        if (this.place == CATEGORY_SPORTS_1) return "Sports";
        if (this.place == CATEGORY_SPORTS_2) return "Sports";
        if (this.place == CATEGORY_SPORTS_3) return "Sports";
        return "Rock";
    }

    public void winAGoldCoin() {
        this.sumOfGoldCoins++;
    }

    public int countGoldCoins() {
        return this.sumOfGoldCoins;
    }

    public boolean isInPenaltyBox() {
        return this.isInInPenaltyBox;
    }

    public void getOutOfPenaltyBox() {
        this.isInInPenaltyBox = false;
    }

    public void sentToPenaltyBox() {
        this.isInInPenaltyBox = true;
    }
}
