package kgurushankar.menuprint;

public class MenuGenerator {

	private MenuGenerator() {
		// should not be able to be constructed
	}

	public static String createMenu(String[] options) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < options.length; i++) {
			out.append(i + 1);
			out.append(" - ");
			out.append(options[i]);
			out.append("\n");
		}
		return out.toString();
	}

}
