/*

A number-guessing game.

*/

import java.util.Scanner;

public class Game {
  static String player;

  public static void main(String[] args){
    System.out.println("Hello Player");
    getUserName();
  }

  static void getUserName() {
    System.out.println("What's yo name?");
    Scanner scanner = new Scanner(System.in);
    player = scanner.nextLine();
  }

}
