package kata.trivia;

import java.util.LinkedList;

/**
 * Author: haiwen.li
 * Time: 8/24/15 5:02 PM
 * <p/>
 * 问题产生者
 */

public class QuestionMaker {

    //TODO: Make question lists type-safe
    //TODO-working-on: Move question lists to a new  class QuestionMaker
    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    public void addPopQuestion(String popQuestion) {
        popQuestions.add(popQuestion);
    }

    public void addScienceQuestion(String scienceQuestion) {
        scienceQuestions.add(scienceQuestion);
    }

    public void addSportsQuestion(String sportsQuestion) {
        sportsQuestions.add(sportsQuestion);
    }

    public void addRockQuestion(String rockQuestion) {
        rockQuestions.add(rockQuestion);
    }
}
