package kata.trivia;

import java.util.LinkedList;

/**
 * Author: haiwen.li
 * Time: 8/24/15 5:02 PM
 * <p/>
 * 问题产生者
 */

public class QuestionMaker {

    //TODO-working-on: Make question lists type-safe
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

    public String removeFirstPopQuestion() {
        return popQuestions.removeFirst().toString();
    }

    public String removeFirstScienceQuestion() {
        return scienceQuestions.removeFirst().toString();
    }

    public String removeFirstSportsQuestions() {
        return sportsQuestions.removeFirst().toString();
    }

    public String removeFirstRockQuestions() {
        return rockQuestions.removeFirst().toString();
    }
}
