package excercises;

public class StringToolBox {

	/** 2a */
	public boolean endsWithStar(String s) {
		return (s.length() > 0 && s.charAt(s.length() - 1) == '*');
	}

	/** 2b */
	public boolean endsWithTwoStars(String s) {
		return (s.length() >= 2 && s.charAt(s.length() - 1) == '*' && s.charAt(s.length() - 2) == '*');
	}

	/** 3 */
	public String removeDashes(String s) {
		return s.replaceAll("-", "");
	}

	/** 4 */
	public String dateFormat(String s) {
		String[] date = s.split("/");
		date[0] = (date[0].length() < 2) ? ("0" + date[0]) : date[0];
		date[1] = (date[1].length() < 2) ? ("0" + date[1]) : date[1];
		return date[0] + "-" + date[1] + "-" + date[2];

	}

	public String lastN(String s, int n) {
		return (s.replaceAll(" ", "").length() < n) ? s + " is too short"
				: s.replaceAll(" ", "").substring(s.length() - n, s.length());
	}

	/** 5a */
	public String last4(String s) {
		return lastN(s, 4);
	}

	/** 5b */
	public String last5(String s) {
		return lastN(s, 5);
	}

	/** 6 */
	public String scroll(String s) {
		return (s.substring(1, s.length())) + Character.valueOf(s.charAt(0));
	}

	/** 7 */
	public String convertName(String s) {
		return s.substring(s.indexOf(',') + 1, s.length()).trim() + " " + s.substring(0, s.indexOf(','));
	}

	/** 8 */
	public String negativeBits(String s) {
		return s.replace('0', ';').replace('1', '\\').replace(';', '1').replace('\\', '0');
	}

	/** 9 */
	public boolean containsSameChar(String s) {
		return (s.replaceAll("" + Character.valueOf(s.charAt(0)), "")).equals("");
	}

	/** 10 */
	public String removeComments(String s) {
		return (!(s.contains("/*") && s.contains("*/"))) ? s
				: (s.substring(0, s.indexOf("/*")) + s.substring(s.indexOf("*/") + 2, s.length()));

	}

	/** firstname LASTNAME */
	public String NameEcho(String s) {
		return s.substring(0, s.indexOf(' ')) + s.substring(s.indexOf(' '), s.length()).toUpperCase();
	}

	public static class Ceasar {
		public static String encrypt(String s, int key) {

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

		public static String decrypt(String s, int key) {
			return encrypt(s, -key);
		}

		private static char getShiftChar(char c, int shift) {
			int x = (int) c + shift;
			if (Character.isUpperCase(c)) {
				int y = x - 65;
				int z = Math.floorMod(y, 26);
				return (char) (z + 65);
			} else {
				int y = x - 97;
				int z = Math.floorMod(y, 26);
				return (char) (z + 97);
			}
		}
	}

	public boolean isPalindrome(String s){
		return (((new StringBuilder(s).reverse()).toString()).equals(s));
	}

	public boolean goodPassword(String s){
		return (!(s.contains(" ")))&&(s.length()>=7)&&(!(s.toUpperCase().equals(s)))&&(!(s.toLowerCase().equals(s)))&&(!(s.replaceAll("[*0-9]", "").equals(s)));
	}
}
