package kata.trivia;

/**
 * Author: haiwen.li
 * Time: 8/24/15 10:47 PM
 * <p/>
 * 描述一个玩家
 */

public class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return this.playerName;
    }

    public void moveForwardSteps(int steps) {

    }
}
