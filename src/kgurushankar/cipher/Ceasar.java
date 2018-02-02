package kgurushankar.cipher;

import java.util.Scanner;

public class Ceasar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String message = in.nextLine();
		// only if needs to be hardcoded
		// message = "Lttlqj ltllqjx ljjp lqfxxjx";
		Ceasar a = new Ceasar();
		for (int i = 0; i < 26; i++) {
			System.out.println(a.encrypt(message, i));
		}
		System.out.println();
	}

	public String encrypt(String s, int key) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				sb.append(getShiftChar(s.charAt(i), key));
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private char getShiftChar(char c, int shift) {
		int x = (int) c + shift;
		if (Character.isUpperCase(c)) {
			int y = x - 65;
			int z = Math.floorMod(y, 26);
			return (char) (z + 65);
		}
		if (Character.isLowerCase(c)) {
			int y = x - 97;
			int z = Math.floorMod(y, 26);
			return (char) (z + 97);
		}
		return c;
	}
}
