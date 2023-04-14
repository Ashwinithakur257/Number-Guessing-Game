import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int secretNumber, guess, maxNumber, maxAttempts, roundCount = 0, totalScore = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.print("Enter the maximum number: ");
        maxNumber = input.nextInt();
        System.out.print("Enter the maximum number of attempts per round: ");
        maxAttempts = input.nextInt();
        
        while (playAgain) {
            roundCount++;
            secretNumber = random.nextInt(maxNumber) + 1;
            System.out.println("Round " + roundCount + ": Guess the number between 1 and " + maxNumber);
            int attemptCount = 0;
            boolean won = false;
            
            while (attemptCount < maxAttempts && !won) {
                attemptCount++;
                System.out.print("Attempt " + attemptCount + ": ");
                guess = input.nextInt();
                
                if (guess == secretNumber) {
                    System.out.println("Congratulations, you won in " + attemptCount + " attempts!");
                    totalScore += maxAttempts - attemptCount + 1;
                    won = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!won) {
                System.out.println("Sorry, you failed to guess the number in " + maxAttempts + " attempts.");
            }
            
            System.out.print("Do you want to play again? (y/n): ");
            String playAgainStr = input.next();
            playAgain = playAgainStr.equals("y");
        }
        
        System.out.println("Game over! You played " + roundCount + " rounds and scored " + totalScore + " points.");
    }

}