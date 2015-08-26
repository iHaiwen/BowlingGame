package kata.trivia;

import java.util.LinkedList;

/**
 * Author: haiwen.li
 * Time: 8/24/15 5:02 PM
 * <p/>
 * 问题产生者
 */

public class QuestionMaker {

    public static final int MAX_NUMBER_OF_QUESTIONS = 50;

    private LinkedList<String> popQuestions = new LinkedList();
    private LinkedList<String> scienceQuestions = new LinkedList();
    private LinkedList<String> sportsQuestions = new LinkedList();
    private LinkedList<String> rockQuestions = new LinkedList();

    public QuestionMaker() {
        for (int i = 0; i < MAX_NUMBER_OF_QUESTIONS; i++) {
            addPopQuestion("Pop Question " + i);
            addScienceQuestion(("Science Question " + i));
            addSportsQuestion(("Sports Question " + i));
            addRockQuestion("Rock Question " + i);
        }
    }

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
        return popQuestions.removeFirst();
    }

    public String removeFirstScienceQuestion() {
        return scienceQuestions.removeFirst();
    }

    public String removeFirstSportsQuestion() {
        return sportsQuestions.removeFirst();
    }

    public String removeFirstRockQuestion() {
        return rockQuestions.removeFirst();
    }
}
