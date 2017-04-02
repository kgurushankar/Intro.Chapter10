package toolbox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringTest extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField input, result, num;
	private JComboBox option;

	public StringTest() {
		super("String test");
		Box box1 = Box.createVerticalBox();
		box1.add(new JLabel("Input:"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("Number:"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("Option:"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("Result:"));

		input = new JTextField(20);
		input.setBackground(Color.WHITE);
		input.addActionListener(this);
		input.selectAll();

		String[] options = { "Ends with an asterisk", "Ends with two asterisks", "Remove dashes",
				"Reformat date with \"/\" to date with \"-\"", "Last 4 characters of a string",
				"Last 5 characters of a string", "Last n characters of a string", "Move first character to end",
				"Convert a name in \"lastname, firstname\" format to \"firstname lastname\"",
				"Convert a name in format \"firstname lastname\" in format \"firstname LASTNAME",
				"Negate a bit sequence", "Check if a string only contains one character", "Remove comments",
				"Ceasar cipher encryption", "Check if a word is a palindrome", "Check if a string is a good password" };
		option = new JComboBox(options);
		option.setSelectedIndex(1);
		option.addActionListener(this);

		result = new JTextField(20);
		result.setBackground(Color.WHITE);
		result.setEditable(false);

		num = new JTextField(20);
		num.setBackground(Color.white);
		num.addActionListener(this);
		num.setEditable(false);

		Box box2 = Box.createVerticalBox();
		box2.add(input);
		box2.add(Box.createVerticalStrut(10));
		box2.add(num);
		box2.add(Box.createVerticalStrut(10));
		box2.add(option);
		box2.add(Box.createVerticalStrut(10));
		box2.add(result);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(box1);
		c.add(box2);
		input.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println(this.getWidth()+" "+this.getHeight());
		StringToolBox a = new StringToolBox();
		num.setEditable(false);
		try {
			switch (option.getSelectedIndex()) {
			case (0): {
				result.setText((a.endsWithStar(input.getText())) ? "Ends with *" : "does not end with *");
				break;
			}
			case (1): {
				result.setText((a.endsWithTwoStars(input.getText())) ? "Ends with two asterisks"
						: "does not end with two asterisks");
				break;
			}
			case (2): {

				result.setText(a.removeDashes(input.getText()));
				break;
			}
			case (3): {
				result.setText(a.dateFormat(input.getText()));
				break;
			}
			case (4): {
				result.setText(
						(a.last4(input.getText()).equals(input.getText() + " is too short")) ? a.last4(input.getText())
								: "The last four characters of " + input.getText() + " is " + a.last4(input.getText()));
				break;
			}
			case (5): {
				result.setText(
						(a.last5(input.getText()).equals(input.getText() + " is too short")) ? a.last5(input.getText())
								: "The last five characters of " + input.getText() + " is " + a.last5(input.getText()));
				break;
			}
			case (6): {
				num.setEditable(true);
				result.setText((a.lastN(input.getText(), Integer.parseInt(num.getText()))
						.equals(input.getText() + " is too short"))
								? a.lastN(input.getText(), Integer.parseInt(num.getText()))
								: "The last " + Integer.parseInt(num.getText()) + " characters of " + input.getText()
										+ " is " + a.lastN(input.getText(), Integer.parseInt(num.getText())));
				break;
			}
			case (7): {
				result.setText(a.scroll(input.getText()));
				break;
			}
			case (8): {
				result.setText(a.convertName(input.getText()));
				break;
			}
			case (9): {
				result.setText(a.NameEcho(input.getText()));
				break;
			}
			case (10): {
				result.setText(a.negativeBits(input.getText()));
				break;
			}
			case (11): {
				result.setText((a.containsSameChar(input.getText()))
						? (input.getText() + " contains only one unique character")
						: (input.getText() + " contains more than one unique character"));
				break;
			}
			case (12): {
				result.setText(a.removeComments(input.getText()));
				break;
			}
			case (13): {
				num.setEditable(true);
				result.setText(StringToolBox.Ceasar.encrypt(input.getText(), Integer.parseInt(num.getText())));
				break;
			}
			case (14): {
				result.setText((a.isPalindrome(input.getText())) ? (input.getText() + " is a palindrome")
						: (input.getText() + " is not a palindrome"));
				break;
			}
			case (15): {
				result.setText((a.goodPassword(input.getText())) ? (input.getText() + " is a good password")
						: (input.getText() + " is not a good password"));
				break;
			}
			}
		} catch (Exception ex) {
			result.setText("Error");
		}
		if (input.getText().equals("")) {
			result.setText("Please enter input");
		}
		input.selectAll();
	}

	public static void main(String[] args) {
		StringTest window = new StringTest();
		window.setBounds(100, 100, 575, 175);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
