package edu.appstate.cs.projectname;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Main sets up and displays the JFrame
 */
public class RunGame{

	static String inputStr = "";
	/**
	 * Main method that sets up the JFram and start the game
	 * @param args
	 */
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Code Quest");
		
		//calls DisplayBoard class to get the JPanel
		DisplayBoard  game = new DisplayBoard();
		window.add(game);

		//TextField for user to input to
		JTextField input = new JTextField(10);
		window.add(input, BorderLayout.SOUTH);

		//Text pane to display instructions
		JTextPane instr = new JTextPane();
		window.add(instr, BorderLayout.EAST);
		instr.setText(getInstructions());
		instr.setEditable(false);

		//\starts the game thread from DisplayBoard
		game.startGame();

		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		//Action Listner to read user input when enter is pressed
		input.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String getInput = input.getText();
				inputStr = getInput;
				input.setText("");
			}
		}
		);
		
	}

	//returns user input as a string
	public static String getInputString(){
		return inputStr;
	}

	/**
	 * gets and returns instructions from corresponding level file
	 * and adds it to the JTextPane
	 * @return returns Instructions String
	 */
	public static String getInstructions()
	{
		String instr = ReadInstructions.readFile(1);
		return instr;
	}
}
