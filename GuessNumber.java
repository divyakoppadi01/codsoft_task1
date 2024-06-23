import java.util.Random;
import java.util.Scanner;
public class GuessNumber
{
 public static void main(String[] args) 
 {
  Scanner scanner = new Scanner(System.in);
  Random random = new Random();
  int min_Range = 1;
  int max_Range = 100;
  int max_Attempts = 10;
  boolean play_Again = true;
  int total_Rounds = 0;
  int total_Attempts = 0;
  int rounds_Won = 0;
  System.out.println("Welcome to the Number Guessing Game!");
  while (play_Again) 
  {
   int numberToGuess = random.nextInt(max_Range - min_Range + 1) + min_Range;
   int attempts = 0;
   boolean guessedCorrectly = false;
   System.out.println("\nRound " + (total_Rounds + 1));
   System.out.println("Guess the number between " + min_Range + " and " + max_Range + ". You have " + max_Attempts + " attempts.");
   while (attempts < max_Attempts && !guessedCorrectly) 
   {
    System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
    int guess = scanner.nextInt();
    attempts++;
    total_Attempts++;
    if (guess < numberToGuess) 
    {
     System.out.println("Too low!");
    }
    else if (guess > numberToGuess) 
    {
     System.out.println("Too high!");
    } 
    else 
    {
     System.out.println("Congratulations! You guessed the correct number.");
     guessedCorrectly = true;
     rounds_Won++;
    }
   }
   if (!guessedCorrectly) 
   {
    System.out.println("Sorry, you've used all " + max_Attempts + " attempts. The correct number was " + numberToGuess + ".");
   }
   total_Rounds++;
   System.out.print("Do you want to play another round? (yes/no): ");
   String playAgainInput = scanner.next().trim().toLowerCase();
   play_Again = playAgainInput.equals("yes");
  }
  System.out.println("\nGame Over!");
  System.out.println("Total rounds played: " + total_Rounds);
  System.out.println("Total attempts made: " + total_Attempts);
  System.out.println("Rounds won: " + rounds_Won);
  System.out.printf("Score: %.2f\n", (double) total_Attempts / total_Rounds);
  scanner.close();
 }
}