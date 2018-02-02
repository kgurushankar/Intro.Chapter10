package kgurushankar.lipogram;

public class LipogramAnalyzer {
	String str;

	public LipogramAnalyzer(String lowerCase) {
		// assigns lowerCase to str
		this.str = lowerCase;
		// TODO Auto-generated constructor stub
	}

	public String mark(char c) {
		return str.replace(c, '#');
		// TODO Auto-generated method stub
	}

	public String allWordsWith(char c) {
		// creates and initializes a new string object
		String out = "";
		// splits string s by spaces
		String words[] = str.split(" ");
		// for each member of array words
		for (String a : words) {
			// if the current string has the char being looked for
			if (a.contains(String.valueOf(c))) {
				// if the string has not been added yet
				if (!(out.contains(a))) {
					out += a + "\n";
				}
			}
		}
		return out;
		// TODO Auto-generated method stub

	}

}
