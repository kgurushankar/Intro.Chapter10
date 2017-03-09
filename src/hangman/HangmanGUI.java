package hangman;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class HangmanGUI extends JPanel implements ActionListener {
	String[] picture;
	JLabel imgBox, missNum;
	JTextField guess, word, misses;
	int numWrong;
	HangmanGame game;
	JPanel mainInfo, win;
	JButton again;
	private static String[] words = { "inheritance", "abstraction", "encapsulation", "polymorphism" };

	public HangmanGUI() {
		game = new HangmanGame(words[(int) (Math.random() * words.length)]);

		numWrong = 0;
		// picture[0] = "PATHS";

		missNum = new JLabel("Number of Failed Guesses: " + numWrong);

		guess = new JTextField("Enter your guess here");
		guess.setColumns(40);
		guess.addActionListener(this);

		word = new JTextField(game.getGuessed());
		word.setColumns(40);
		word.setEditable(false);

		misses = new JTextField(game.getTried());
		misses.setColumns(40);
		misses.setEditable(false);

		// imgBox.setIcon(new ImageIcon(picture[1]));

		mainInfo = new JPanel(new GridLayout(0, 1));
		mainInfo.add(missNum);
		mainInfo.add(new JLabel("Guessed Letters"), BorderLayout.CENTER);
		mainInfo.add(misses);
		mainInfo.add(new JLabel("Word"), BorderLayout.CENTER);
		mainInfo.add(word);
		mainInfo.add(new JLabel("Guess"), BorderLayout.CENTER);
		mainInfo.add(guess);
		add(mainInfo, BorderLayout.LINE_END);

		again = new JButton("Play Again?");
		again.addActionListener(this);

		win = new JPanel(new GridLayout(0, 1));
		win.add(new JLabel("You Win!!!!"));
		win.add(again);

		guess.selectAll();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		word.setText(game.getGuessed());
		misses.setText(game.getTried());
		missNum.setText("Number of Failed Guesses: " + numWrong);

		if (e.getSource() == guess) {
			// System.out.println(this.getWidth() + " " + this.getHeight());

			String a = guess.getText();
			if (a.length() == 1) {
				int b = game.tryLetter(a.charAt(0));
				if (b == -1) {
					++numWrong;
					guess.setText("Incorrect");
				} else if (b == 0) {
					guess.setText("You have already guessed " + a.charAt(0));
				} else if (b == 1) {
					guess.setText("Correct");
				}

			} else {
				guess.setText("Your input was too long!");
			}

			if (game.getGuessed().equals(game.getWord())) {
				add(win, BorderLayout.SOUTH);
				validate();
				repaint();
				// System.out.println("Win");
			}
			guess.selectAll();
		}
		if (e.getSource() == again) {
			// System.out.println("Again...");
			remove(win);
			validate();
			repaint();
			numWrong = 0;
			guess.setText("Enter your guess here");
			game = new HangmanGame();
			guess.selectAll();

		}
		word.setText(game.getGuessed());
		misses.setText(game.getTried());
		missNum.setText("Number of Failed Guesses: " + numWrong);

	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Hangman");
		window.setBounds(300, 300, 500, 275);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		HangmanGUI panel = new HangmanGUI();
		panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);

		// window.setResizable(false);
		window.setVisible(true);
	}

	public void reset() {
		game = new HangmanGame();

	}

}
