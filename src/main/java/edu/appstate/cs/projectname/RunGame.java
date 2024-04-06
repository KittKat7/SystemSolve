package edu.appstate.cs.projectname;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		DisplayBoard  gameBoard = new DisplayBoard();
		window.add(gameBoard);

		//Split pane to display instructions on top and input area on bottom
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		//text pane to dispay instruction noneditable to users
		JTextPane instructionsPane = new JTextPane();
		instructionsPane.setText(getInstructions());
		instructionsPane.setEditable(false);

		//Panel to hold text area and submit button
		JPanel textAreaJPanel = new JPanel();

		//Text area to allow user input. Set specific max size and linewrap
		JTextArea inputArea = new JTextArea();
		inputArea.setPreferredSize(new Dimension(350,250));
		inputArea.setMaximumSize(new Dimension(350,250));
		inputArea.setLineWrap(true);

		// Buttom for users to press to submit text
		JButton submitButton = new JButton();
		submitButton.setText("Submit");

		//adds text area and submit button to panel
		textAreaJPanel.add(inputArea);
		textAreaJPanel.add(submitButton);

		//adds instructions panel and text area panel to the top/botton of
		//the split area
		splitPane.setTopComponent(instructionsPane);
		splitPane.setBottomComponent(textAreaJPanel);

		//sets a defined black border between the two areas
		splitPane.setBorder(BorderFactory.createLineBorder(Color.black));

		//adds the total split pane to the window frame
		window.add(splitPane, BorderLayout.EAST);

		//\starts the game thread from DisplayBoard
		gameBoard.startGame();

		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		//Action Listner to read user input when enter is pressed
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String getInput = inputArea.getText();
				inputStr = getInput;
			}
		}
		);
	}

	//returns user input as a string
	public static String getInputString(){
		
		System.out.print(inputStr);
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
