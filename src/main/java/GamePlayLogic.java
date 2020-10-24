import java.util.Scanner;

public class GamePlayLogic {
    private static int enteredNumber;
    private static int remainingMatches = 20;

    public int getEnteredNumber() {
        return enteredNumber;
    }

    public int getRemainingMatchesAfterAIMove() {
        return remainingMatches;
    }

    public int getRemainingMatchesAfterPlayerMove(int enteredNumber) {
        return remainingMatches -= enteredNumber;
    }

    private static class AIPlay {
        private int amountOfMatchesToRemove() {
            final int FOUR_MATCHES = 4;
            final int THREE_MATCHES_FOR_OPENING_AI_MOVE = 3;

            if (remainingMatches == 20) {
                remainingMatches -= THREE_MATCHES_FOR_OPENING_AI_MOVE;
                return THREE_MATCHES_FOR_OPENING_AI_MOVE;
            } else remainingMatches -= FOUR_MATCHES - enteredNumber;
            return FOUR_MATCHES - enteredNumber;
        }
    }

    public int getAIPlay() {
        AIPlay aiPlay = new AIPlay();
        return aiPlay.amountOfMatchesToRemove();
    }

    public boolean isEnteredNumberCorrect(int enteredNumber) {
        return (enteredNumber > 0 && enteredNumber < 4);
    }

    public static void playTheGame(int remainingMatches) {
        GamePlayLogic gamePlayLogic = new GamePlayLogic();
        Scanner scanner = new Scanner(System.in);
        if (gamePlayLogic.getRemainingMatchesAfterAIMove() == 20) {
            ReportInfo.reportRemainingMatchesAfterAIMove(gamePlayLogic);
            ReportInfo.reportAIPlay(gamePlayLogic);
            ReportInfo.reportRemainingMatchesAfterAIMove(gamePlayLogic);
        }
        ReportInfo.reportPlayerTurn();
        enteredNumber = scanner.nextInt();
        while (!gamePlayLogic.isEnteredNumberCorrect(enteredNumber)) {
            ReportInfo.reportWrongNumberOfEnteredMatches();
            ReportInfo.reportPlayerTurn();
            enteredNumber = scanner.nextInt();
        }
        ReportInfo.getRemainingMatchesAfterPlayerMove(gamePlayLogic);
        ReportInfo.reportAIPlay(gamePlayLogic);
        ReportInfo.reportRemainingMatchesAfterAIMove(gamePlayLogic);
        if (gamePlayLogic.getRemainingMatchesAfterAIMove() == 1) {
            ReportInfo.reportPlayerDefeat();
        } else playTheGame(GamePlayLogic.remainingMatches);
    }
}
