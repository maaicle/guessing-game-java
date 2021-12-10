import java.util.Scanner;
import java.util.Random;

public class Game {

  public static void main(String[] args){
    String player;
    int number;
    int firstGuess;

    System.out.println("Hello Player");
    player = getUserName();
    System.out.printf("Hi, %s%n", player);
    number = pickRandom();
//    System.out.printf("Secret number is %d%n", number);
    System.out.println("What number am I thinking of?");
    firstGuess = getGuess();
    checkAnswer(number, firstGuess);
  }

  public static String getUserName() {
    System.out.println("What's yo name?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static int pickRandom() {
    Random rand = new Random();
    return rand.nextInt(100);
  }

  public static int getGuess() {
    String input;
    int guess = 0;
    boolean guessIsInt = false;

    while (guessIsInt == false) {

      Scanner scanner = new Scanner(System.in);
      input = scanner.nextLine();

      try {
        guess = Integer.parseInt(input);
      }
      catch(Exception ex) {
        System.out.println("Error: Make it an integer, dawg.");
        continue;
      }
      guessIsInt = true;
    }

    return guess;
  }

  public static void checkAnswer(int number, int guess) {
    int guessCount = 1;
    String plural;

    do {
      if (guess < 1 || guess > 100) {
        System.out.println("Error: C'mon guy, pick 1 - 100 :(");
        guess = getGuess();
      }
      else if (number < guess) {
        System.out.println("Too High. Try again.");
        guess = getGuess();
        guessCount++;
      }
      else if (number > guess) {
        System.out.println("Too low. Try again.");
        guess = getGuess();
        guessCount++;
      }
    } while (number != guess);

    if(guessCount == 1)
      plural = "try";
    else
      plural = "tries";

    System.out.printf("Yup, you guessed it! I was thinking of %d and you got it in %d %s. See ya :)%n", number, guessCount, plural);
  }
}
