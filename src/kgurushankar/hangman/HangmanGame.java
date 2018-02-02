package kgurushankar.hangman;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class HangmanGame {
	String word;
	StringBuffer guess;
	StringBuffer chars;

	public HangmanGame() {
		String FilePath = "C:/Users/kesha/Google Drive/CS/EclipseWorkspace/Chapter 10 � Strings/src/hangman/words.txt";
		try {
			BufferedReader f = new BufferedReader(new FileReader(FilePath));
			String test = "";
			while (test.length() < 5) {
				try (Stream<String> lines = Files.lines(Paths.get(FilePath))) {
					test = lines.skip((long) (Math.random() * 10000)).findFirst().get();
				} catch (IOException e) {
					System.out.println("File Error!!");
				}
			}
			this.word = test;
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		guess = new StringBuffer(this.word.length());
		for (int i = 0; i < this.word.length(); i++) {
			guess.append('_');
		}
		chars = new StringBuffer(26);

	}

	public HangmanGame(String word) {
		this.word = word;
		guess = new StringBuffer(this.word.length());
		for (int i = 0; i < this.word.length(); i++) {
			guess.append('_');
		}
		chars = new StringBuffer(26);
		// for (int i = 0; i < this.chars.length(); i++) {
		// guess.append(' ');
		// }
	}

	/** Characters that have been inputed already */
	public String getTried() {
		return chars.toString();
	}

	/** Word with blanks */
	public String getGuessed() {
		return guess.toString();
	}

	public String getWord() {
		return word;
	}

	/**
	 * @param c Character to be tried
	 * 
	 * @return 0 if letter has already been tried, 1 if letter is correct, and
	 *         -1 of letter is incorrect
	 */
	public int tryLetter(char c) {

		// chars.setCharAt(((Character.isUpperCase(c))?(c-64):(c-96)), c);

		if (this.chars.indexOf("" + c) != -1) {
			return 0;
		}
		this.chars.append(c);
		if (this.word.contains("" + c)) {
			for (int i = 0; i < this.word.length(); i++) {
				if (this.word.charAt(i) == c) {
					this.guess.setCharAt(i, c);
				}
			}
			return 1;
		} else {
			return -1;
		}

	}

	public HangmanGame newGame() {
		return new HangmanGame();
		
	}

}
