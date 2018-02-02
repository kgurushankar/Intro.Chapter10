package kgurushankar.cipher;

import java.util.Scanner;

public class Atbash {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String message = in.nextLine();
		// only if needs to be hardcoded
		// message = "Lttlqj ltllqjx ljjp lqfxxjx";
		Atbash a = new Atbash();
		System.out.println(a.encrypt(message));
		System.out.println();
	}

	public String encrypt(String s) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				sb.append(getShiftChar(s.charAt(i)));
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private char getShiftChar(char c) {
		int x = (int) c;
		if (Character.isUpperCase(c)) {
			int y = x - 65;
			int z = 25 - y;
			return (char) (z + 65);
		}
		if (Character.isLowerCase(c)) {
			int y = x - 97;
			int z = 25 - y;
			return (char) (z + 97);
		}
		return c;
	}
}
