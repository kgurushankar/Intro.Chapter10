package cipher;

/**
 * The isogram cipher takes an isogram (a word with no repeating letters) as the
 * key, and replaces each letter of the ciphertext with the following letter in
 * the isogram. For example, the isogram "TROUBLEMAKING" maps T->R, R->O, ...,
 * N->G, G->T. ("GATE" becomes "TKRM").
 */
public class Isogram {
	public static void main(String[] args) {
		int SHIFT = 1;
		// key
		String ISOGRAM = "subdermatoglyphic";
		String message = "Meet me at secret location at noon on Wednesday";

		String ciphertext = encrypt(ISOGRAM, message, SHIFT);
		System.out.println("Ciphertext:\t\t" + ciphertext);

		String decrypted_plaintext = decrypt(ISOGRAM, ciphertext, SHIFT);
		System.out.println("Decrypted text: \t" + decrypted_plaintext);
	}

	private static String decrypt(String isogram, String ciphertext, int shift) {
		return encrypt(reverse(isogram), ciphertext, shift);
	}

	private static String encrypt(String isogram, String s, int shift) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			sb.append(getShiftChar(isogram, s.charAt(i), shift));
		}
		return sb.toString();
	}

	private static char getShiftChar(String isogram, char c, int shift) {
		int charIndex = isogram.indexOf(c + "");

		if (0 <= charIndex) {
			int shiftCharIndex = (charIndex + shift) % isogram.length();
			char shiftChar = isogram.charAt(shiftCharIndex);
			return shiftChar;
		}

		return c;
	}

	private static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}