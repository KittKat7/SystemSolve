package edu.appstate.cs.codequest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class InterpreterTest {
	// TODO:

	private Board board = null;
	private Interpreter inter = null;
	private int x = -1;
	private int y = -1;

	private boolean initInterpreter() {
		board = null;
		inter = null;
		board = new Board();

		if (board == null)
			return false;

		x = 1;
		y = 1;

		for (int i = 0; i < board.board.length; i++) {
			for (int j = 0; j < board.board[i].length; j++)
				board.setObject(new PathObject(), j, i);
		}

		board.setObject(new PlayerObject(board, x, y), x, y);

		inter = new Interpreter(board.getPlayer(), board);
		return true;
	}

	@Test
	public void testMoveUpCommand() {
		if (!initInterpreter()) {
			assertTrue(false, "Failed to init the interpreter");
			return;
		}

		try {
			inter.parse("moveU");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false, "IterpreterException occured");
			return;
		}
		assertTrue(board.getObject(x, y - 1) instanceof PlayerObject, "Failed to move player up");
	}

	@Test
	public void testMoveDownCommand() {
		if (!initInterpreter()) {
			assertTrue(false, "Failed to init the interpreter");
			return;
		}

		try {
			inter.parse("moveD");
		} catch (Exception e) {
			assertTrue(false, "IterpreterException occured");
			return;
		}
		assertTrue(board.getObject(x, y + 1) instanceof PlayerObject, "Failed to move player down");
	}

	@Test
	public void testMoveLeftCommand() {
		if (!initInterpreter()) {
			assertTrue(false, "Failed to init the interpreter");
			return;
		}

		try {
			inter.parse("moveL");
		} catch (Exception e) {
			assertTrue(false, "IterpreterException occured");
			return;
		}
		assertTrue(board.getObject(x - 1, y) instanceof PlayerObject, "Failed to move player left");
	}

	@Test
	public void testMoveRightCommand() {
		if (!initInterpreter()) {
			assertTrue(false, "Failed to init the interpreter");
			return;
		}

		try {
			inter.parse("moveR");
		} catch (Exception e) {
			assertTrue(false, "IterpreterException occured");
			return;
		}
		assertTrue(board.getObject(x + 1, y) instanceof PlayerObject, "Failed to move player right");
	}
}
