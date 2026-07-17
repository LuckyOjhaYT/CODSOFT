import java.util.Scanner;

/**
 * NumberGame
 */
public class NumberGame {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int num = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;
        int attempt = 7;

        System.out.println("=================================");
        System.out.println("  Guess the number between 1-100 ");
        System.out.println("  Enter -1 to quit at any time   ");
        System.out.println("=================================");

        while (attempt > 0) {
            System.out.println("Attempts Left: " + attempt);
            System.out.print("Your guess: ");
            int guessedNum = sc.nextInt();

            if (guessedNum == -1)
                break;

            if (guessedNum == num) {
                System.out.println("CONGRATS!!!");
                hasWon = true;
                break;

            } else if (guessedNum > num)
                System.out.println("too high!");
            else if (guessedNum < num)
                System.out.println("too low!");

            attempt--;
        }

        if (!hasWon)
            System.out.println("Better luck next time");

        System.out.println("The number was " + num);

        sc.close();

    }
}