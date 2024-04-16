package edu.appstate.cs.codequest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * Main sets up and displays the JFrame
 */
public class RunGame {

	static String inputStr = "";
	protected static boolean b;

	/**
	 * Main method that sets up the JFram and start the game
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Code Quest");

		// calls DisplayBoard class to get the JPanel
		DisplayBoard gameBoard = new DisplayBoard();
		window.add(gameBoard);

		// Split pane to display instructions on top and input area on bottom
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		// text pane to dispay instruction noneditable to users
		JTextPane instructionsPane = gameBoard.getInstructionsPane();
		instructionsPane.setPreferredSize(new Dimension(350, 290));
		instructionsPane.setMaximumSize(new Dimension(350, 290));
		instructionsPane.setEditable(false);

		// Panel to hold text area and submit button
		JPanel textAreaJPanel = new JPanel();

		// Text area to allow user input. Set specific max size and linewrap
		JTextArea inputArea = new JTextArea();
		inputArea.setPreferredSize(new Dimension(350, 220));
		inputArea.setMaximumSize(new Dimension(350, 220));
		inputArea.setLineWrap(true);

		// Buttons for users to press
		JButton submitButton = new JButton();
		submitButton.setText("Submit");
		JButton nextLevelButton = new JButton();
		nextLevelButton.setText("Next Level");
		JButton resetButton = new JButton();
		resetButton.setText("Reset");

		// adds text area and submit button to panel
		textAreaJPanel.setLayout(new BorderLayout());
		textAreaJPanel.add(inputArea, BorderLayout.NORTH);
		textAreaJPanel.add(submitButton, BorderLayout.CENTER);

		// temporary until movement is done
		boolean b = true;
		// Will test for player at goal and add the appropriate button.
		if (!b) {
			textAreaJPanel.add(resetButton, BorderLayout.SOUTH);
			resetButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameBoard.setButton(true);
					gameBoard.setIndex(gameBoard.getIndex());
					inputArea.setText("");
				}
			});
		} else if (b)// if(DisplayBoard.playerAtGoal)
		{
			textAreaJPanel.add(nextLevelButton, BorderLayout.SOUTH);

			nextLevelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameBoard.setButton(true);
					gameBoard.setIndex(gameBoard.getIndex() + 1);
					isAtGoalRG(gameBoard.level.getIsAtGoal());
				}
			});
		}

		// adds instructions panel and text area panel to the top/botton of
		// the split area
		splitPane.setTopComponent(instructionsPane);
		splitPane.setBottomComponent(textAreaJPanel);

		// sets a defined black border between the two areas
		splitPane.setBorder(BorderFactory.createLineBorder(Color.black));

		// adds the total split pane to the window frame
		window.add(splitPane, BorderLayout.EAST);

		// \starts the game thread from DisplayBoard
		gameBoard.startGame();

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		// Action Listner to read user input when enter is pressed
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getInput = inputArea.getText();
				gameBoard.level.runCode(getInput);
				System.out.print(getInput);
			}
		});
	}

	public static void isAtGoalRG(boolean bo){
		b = bo;
	}

	// returns user input as a string
	public static String getInputString() {
		return inputStr;
	}

	/**
	 * gets and returns instructions from corresponding level file
	 * and adds it to the JTextPane
	 * 
	 * @return returns Instructions String
	 */
	public static String getInstructions(int index) {
		String instr = ReadInstructions.readFile(Integer.toString(index));
		return instr;
	}
}
