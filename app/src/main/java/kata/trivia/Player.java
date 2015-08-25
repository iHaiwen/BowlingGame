package kata.trivia;

/**
 * Author: haiwen.li
 * Time: 8/24/15 10:47 PM
 * <p/>
 * 描述一个玩家
 */

public class Player {
    private String playerName;
    private int place;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return this.playerName;
    }

    public void moveForwardSteps(int steps) {
        this.place += steps;
        if (this.place > 11) {
            this.place -= 12;
        }
    }

    public int getPlace() {
        return this.place;
    }

    //TODO-working-on: Move method currentCategory() to Player
    public String currentCategory() {
        if (this.place == 0) return "Pop";
        if (this.place == 4) return "Pop";
        if (this.place == 8) return "Pop";
        if (this.place == 1) return "Science";
        if (this.place == 5) return "Science";
        if (this.place == 9) return "Science";
        if (this.place == 2) return "Sports";
        if (this.place == 6) return "Sports";
        if (this.place == 10) return "Sports";
        return "Rock";
    }
}
