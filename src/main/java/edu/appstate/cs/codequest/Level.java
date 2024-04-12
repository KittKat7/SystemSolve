package edu.appstate.cs.codequest;

import java.io.IOException;

public class Level {

	private int index;
	private Board board;
	private Interpreter interpreter;
	private PlayerObject player;

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
		interpreter = new Interpreter(player);
	}

}
