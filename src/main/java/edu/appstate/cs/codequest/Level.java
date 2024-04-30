package edu.appstate.cs.codequest;

import java.io.IOException;

public class Level {

	private int index;
	private Board board;
	private Interpreter interpreter;
	private PlayerObject player;
	private boolean levelComplete;

	/**
	 * Constructs a Level instance based on the provided level index. Loads the
	 * board, and initializes the player and interpreter fields.
	 * 
	 * @param index
	 * @throws IOException
	 */
	public Level(int index) throws IOException { // TODO: Handle IOException
		this.index = index;
		board = Board.createBoardFromFile("level" + index);
		player = board.getPlayer();
		interpreter = new Interpreter(player, board);
	}

	/**
	 * Sets the levelComplete variable.
	 * 
	 * @param b The new levelComplete value.
	 */
	public void setComplete(boolean b) {
		levelComplete = b;
	}

	/**
	 * Returns true if the player is at the goal, and false otherwise.
	 * 
	 * @return True if the player is at the goal, or false otherwise.
	 */
	public boolean getIsAtGoal() {
		return player.getIsAtGoal() || levelComplete;
	}

	/**
	 * Returns the Level instance of board
	 * 
	 * @return board object
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * returns player object
	 * @return player object
	 */
	public PlayerObject getPlayerObject()
	{
		return player;
	}

	/**
	 * Runs the provided code.
	 * 
	 * @param str The code which is to be run.
	 */
	public void runCode(String str) {
		try {
			interpreter.parse(str);
		} catch (InterpretingException e) {
			System.out.println("An exception in the code was encountered.");
			System.out.println(e.getMessage());
		}
	}

}
