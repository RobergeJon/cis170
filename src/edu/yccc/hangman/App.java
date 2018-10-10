package edu.yccc.hangman;

import java.util.Scanner;

public class App {
// contains WordBank
// replaces letters and turns them to int for mask
// creates game mask replaces new int with "*"
// sets wrong guesses to default(0) will update while game is being played
	// All called later(besides wordBank)
	
	public static int wrongGuess = 0;
	
	public static String[] wordBank = {"horse","cow","java","computer","Code","eclipse","rock","toast"};
	
	public static String word =wordBank[(int) (Math.random() * wordBank.length)];
	
	public static String gameMask = new String(new char[word.length()]).replace("\0","*");
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // creates instance of scanner/ takes input
		while (wrongGuess < 10 && gameMask.contains("*")) {
			System.out.println("Guess a Letter"); // prompts user
			System.out.println(gameMask); // prints current state of game
			String wrongGuess = sc.next();
			hang(wrongGuess); 
		}
		sc.close();
	}
	
	
	
	public static void hang(String userGuess) { //applies input into replacing letter
		String newgameMask = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == userGuess.charAt(0)) { // replaces letter if correct input
				newgameMask += userGuess.charAt(0);
			} else if (gameMask.charAt(i) != '*') {
				newgameMask += word.charAt(i);
			}else {
				newgameMask +="*";
			}
		}
		if (gameMask.equals(word)) { // completed game
			System.out.println("You WON! the word was  " + word + "!");
			// NEXT STEP refresh game. IF/Then statement asking "Keep Playing?"
			
			
		}
		if (gameMask.equals(newgameMask)) { // Adds 1 wrong guess to counter
			wrongGuess++;
			hangmanCounter();
		}else {
			gameMask = newgameMask;
		}
			
			
		
		
	}
	
	
	
	public static void hangmanCounter() { // method prints out message depending on amount of wrong Guesses
		if (wrongGuess == 1) {
			System.out.println("Wrong Guess! You only get 9 more Guesses");
		}else if (wrongGuess < 1 && wrongGuess < 10) {
			System.out.println("Wrong Guess! Keep trying");
		}else if (wrongGuess == 10)
			System.out.println("Wrong Guess! GAME OVER! The Word was " + word); // Ends game
			// Add a reset button. Prompt user to answer "Retry?(y or n)"
		
	}

	
}
	