public class ReportInfo {
    public static void reportRemainingMatchesAfterAIMove(GamePlayLogic gamePlayLogic) {
        System.out.printf("Колличество спичек на столе = '%d'.\n", gamePlayLogic.getRemainingMatchesAfterAIMove());
    }

    public static void getRemainingMatchesAfterPlayerMove(GamePlayLogic gamePlayLogic) {
        System.out.printf("Колличество спичек на столе = '%d'.\n", gamePlayLogic.getRemainingMatchesAfterPlayerMove(
                gamePlayLogic.getEnteredNumber()));
    }

    public static void reportWrongNumberOfEnteredMatches() {
        System.out.println("Введено неверное число спичек!");
    }

    public static void reportAIPlay(GamePlayLogic gamePlayLogic) {
        System.out.printf("     Компьютер взял %d спичек.\n", gamePlayLogic.getAIPlay());
    }

    public static void reportPlayerTurn() {
        System.out.print("     Ваш ход. Введите число спичек: ");
    }

    public static void reportPlayerDefeat() {
        System.out.println("     Вы проиграли!");
    }
}