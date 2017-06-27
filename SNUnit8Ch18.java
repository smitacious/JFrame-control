/************************************************************************************************************************
* <SNUnit8Ch18.java>
* <Norris Smith >
* <12/7/15>
* <Program is designed to display a JFrame window with 5 buttons, the buttons control the background color of the window.
*  The buttons texts and matching colors for the background are randomly assigned. No color will be duplicated within the
*  buttons. Background will change up the user clicking a button, background will continue to change colors with another
*  button is pushed. That is after the buttons have been re-randomly assigned>
************************************************************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class SNUnit8Ch18 extends JFrame // loads the standard functions of windows
{
	private static final int WIDTH = 450; // sets the width to 450 pixels
	private static final int HEIGHT = 300; //sets the height to 300 pixels

	JButton button[]; // declare the array named button
	String[] colors = {"Red","Blue","Yellow","Green","White"}; // adds the text to the array of colors
	String[] gen = {"Red","Blue","Yellow","Green","White"}; // add the text to array of gen

	public SNUnit8Ch18()
	{
		setTitle("Color Changing Frame"); // sets the title of window to quoted words
		setSize(WIDTH, HEIGHT); // sets the size of the window
		setLayout(new FlowLayout()); // adds the components to the upper right corner
		setDefaultCloseOperation(EXIT_ON_CLOSE); // function to enure the program is closed when desired
		createContents(); // calls createContents()
		setVisible(true); // sets the window to visible
	} // ends SNUnit8Ch18

	private void createContents()
	{
		button = new JButton[colors.length]; // creates a new button
		for (int i = 0; i<colors.length; i++)
		{
			button[i] = new JButton(colors[i]); //assigns the proper positions the correct string of text
			button[i].addActionListener(new ButtonListener()); // add a Listener
			add(button[i]); // adds the string text to the appropriate button
		} // ends for loop once i has passed the length of the color array
	} // ends createContents
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Container contentPane = getContentPane();

			int k = 0;
			int i = 0;
			Random rand = new Random(); // randomly generates an integer
			JButton event; //creates an event
			String previousColor;
			Set<String> color = new HashSet<>();
			event = (JButton)e.getSource();
			previousColor = event.getText(); // text is being assigned to previousColor
			int index = 0;
			for (i =0 ;i<colors.length;i++)
			{
			  if (((JButton)contentPane.getComponent(i)).getText().equals(previousColor))// checks to see if text inside the buttons match
			  {
				   index =i;
				   break; //ends loop
			  } // ends if statement
			} //ends for loop
			if (((JButton)e.getSource()).getText().equals("Red"))
			{
				contentPane.setBackground(Color.RED); // sets background to color of red
			} // ends if statement
			else if (((JButton)e.getSource()).getText().equals("Blue"))
			{
				contentPane.setBackground(Color.BLUE); // sets background to color of blue
			} // ends if statement
			else if (((JButton)e.getSource()).getText().equals("Yellow"))
			{
				contentPane.setBackground(Color.YELLOW); // sets background to the color of yellow
			} //ends if statement
			else if (((JButton)e.getSource()).getText().equals("Green"))
			{
				contentPane.setBackground(Color.GREEN); // sets background to the color of green
			} // ends if statement
			else
			{
				contentPane.setBackground(Color.WHITE); // sets background to color of white
			} // ends else statement

			while(true)
			{
				int j = rand.nextInt(colors.length); // assigns a random number to j
				if (j == index  && !previousColor.equalsIgnoreCase(gen[index]) && color.add(colors[j]) )
				{
					gen[k] = colors[j]; // assigns the same position same color in both gen and colors arrays
					k++; //increases k by one
				} // ends if statement
				else if (color.add(colors[j]))
				{
					gen[k] = colors[j]; // assigns the same position same color in both gen and colors arrays
					k++; //increases k by one
				} // ends if statement
				if (k == 5)
				{
					break; // ends loop
				} //ends break statement
			} // ends while loop
			for (i = 0; i < colors.length; i++) //assigns each button a color text
			{
				button[i].setText(gen[i]);
			} //ends for loop
		} // ends actionPerformed
	} // ends class ButtonListener
	public static void main(String[] args)
	{
		new SNUnit8Ch18();
	} // ends main
} // ends SNUnit8Ch18 class





