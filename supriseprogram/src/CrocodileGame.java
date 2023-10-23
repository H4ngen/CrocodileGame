import java.util.Random;
import java.util.Scanner;

class CrocodileGame {
    private static final int NUM_TEETH = 5;
    private static final int WINNING_SCORE = 3;

    private int[] teeth;
    private int currentPlayer;
    private int player1Score;
    private int player2Score;
    private boolean gameRunning;

    public CrocodileGame() {
        teeth = new int[NUM_TEETH];
        currentPlayer = 1;
        player1Score = 0;
        player2Score = 0;
        gameRunning = true;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Ласкаво просимо до гри 'Крокодил'!");

        while (gameRunning) {
            System.out.println("Гравець " + currentPlayer + ", введіть номер зуба, який хочете натиснути (1-" + NUM_TEETH + "):");
            int selectedTooth = scanner.nextInt();

            if (selectedTooth < 1 || selectedTooth > NUM_TEETH) {
                System.out.println("Неправильний номер зуба. Спробуйте ще раз.");
                continue;
            }

            int biteTooth = random.nextInt(NUM_TEETH) + 1;
            System.out.println("Крокодил вкусив зуб номер " + biteTooth + "!");

            if (selectedTooth == biteTooth) {
                System.out.println("Гравець " + currentPlayer + " втратив очко!");
                if (currentPlayer == 1) {
                    player1Score++;
                } else {
                    player2Score++;
                }
            } else {
                System.out.println("Гравець " + currentPlayer + " вижив!");
            }

            System.out.println("Рахунок: Гравець 1: " + player1Score + " | Гравець 2: " + player2Score);

            if (player1Score >= WINNING_SCORE || player2Score >= WINNING_SCORE) {
                if (player1Score > player2Score) {
                    System.out.println("Гравець 1 переміг!");
                } else if (player2Score > player1Score) {
                    System.out.println("Гравець 2 переміг!");
                } else {
                    System.out.println("Нічия!");
                }

                System.out.println("Бажаєте розпочати нову гру? (Так/Ні)");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("так")) {
                    gameRunning = false;
                } else {
                    player1Score = 0;
                    player2Score = 0;
                }
            }


            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("Дякуємо за гру!");
        scanner.close();
    }
}
