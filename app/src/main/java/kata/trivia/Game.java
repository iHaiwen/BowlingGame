package kata.trivia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Game {

    private ArrayList players = new ArrayList();
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];

    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    private static Logger logger = Logger.getLogger("kata.trivia.Game");
    private static FileHandler fileHandler = null;

    public Game() {
        try {
            fileHandler = new FileHandler("%h/Game-loggin.log", 10000000, 1, true);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void add(String playerName) {


        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        logger.info(playerName + " was added");
        logger.info("They are player number " + players.size());
    }

    private int howManyPlayers() {
        return players.size();
    }

    public void roll(int rollingNumber) {
        logger.info(players.get(currentPlayer) + " is the current player");
        logger.info("They have rolled a " + rollingNumber);

        if (inPenaltyBox[currentPlayer]) {
            if (rollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                logger.info(players.get(currentPlayer) + " is getting out of the penalty box");
                currentPlayerMovesToNewPlaceAndAnswersAQuestion(rollingNumber);
            } else {
                logger.info(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            currentPlayerMovesToNewPlaceAndAnswersAQuestion(rollingNumber);
        }

    }

    private void currentPlayerMovesToNewPlaceAndAnswersAQuestion(int rollingNumber) {
        places[currentPlayer] = places[currentPlayer] + rollingNumber;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        logger.info(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        logger.info("The category is " + currentCategory());
        askQuestion();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            logger.info(popQuestions.removeFirst().toString());
        if (currentCategory() == "Science")
            logger.info(scienceQuestions.removeFirst().toString());
        if (currentCategory() == "Sports")
            logger.info(sportsQuestions.removeFirst().toString());
        if (currentCategory() == "Rock")
            logger.info(rockQuestions.removeFirst().toString());
    }


    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
            } else {
                nextPlayer();
                return true;
            }


        } else {
            return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
        }
    }

    private boolean currentPlayerGetsAGoldCoinAndSelectNextPlayer() {
        logger.info("Answer was correct!!!!");
        purses[currentPlayer]++;
        logger.info(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean isGameStillInProgress = isGameStillInProgress();
        nextPlayer();

        return isGameStillInProgress;
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        logger.info("Question was incorrectly answered");
        logger.info(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayer();

        //TODO-later: The value of the method Game.wrongAnswer() is unnecessary and should be eliminated.
        return true;
    }

    private boolean isGameStillInProgress() {
        return !(purses[currentPlayer] == 6);
    }
}
