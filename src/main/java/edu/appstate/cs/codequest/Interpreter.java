package edu.appstate.cs.codequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Interpreter {
	private static final HashSet<String> KEYWORDS = new HashSet<String>(Arrays.asList(
			"var", "while", "moveU", "moveD", "moveL", "moveR"));
	private PlayerObject player;
	private Board board;

	private boolean isInterpreting;

	ArrayList<String> lines = new ArrayList<>();

	public Interpreter(PlayerObject player, Board board) {
		this.player = player;
		this.board = board;
		isInterpreting = false;
	}

	/**
	 * Parses the string param, and returns a string with the completion/error
	 * message. Tries to parse and run all the provided commands. If an error
	 * occurs, the message will be returned.
	 * 
	 * @param str The command/script the player entered.
	 * @return The completion/error message as a result of parsing the string.
	 */
	public void parse(String str) throws InterpretingException {
		if (isInterpreting)
			return;
		try {
			isInterpreting = true;
			lines = new ArrayList<String>(Arrays.asList(str.split("\n")));
			while (lines.size() > 0) {
				parseLine();
			}
		} catch (Exception e) {
			isInterpreting = false;
			throw e;
		}
	}// parse(String)

	/**
	 * Parses a single command. Returns an empty string or an error message if one
	 * is thrown.
	 * 
	 * @param line The command to parse
	 * @return Either an empty string, or an error message
	 */
	private void parseLine() throws InterpretingException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		String line = lines.get(0);
		lines.remove(0);
		// Comment
		if (line.startsWith("#") || line.trim().isEmpty())
			return;
		// Movement
		else if (line.startsWith("move")) {
			switch (line.substring("move".length())) {
				case "U":
					player.move("up");
					break;
				case "D":
					player.move("down");
					break;
				case "L":
					player.move("left");
					break;
				case "R":
					player.move("right");
					break;
				default:
					throw new InterpretingException("Missing move direction, IE `moveU`");
			}
		}
		// If statement
		else if (line.startsWith("if ")) {
			// Remove the 'if ' and the ':'
			boolean condition = parseCondition(line.trim().substring(0, line.trim().length() - 1).substring(3));
			while (lines.get(0).startsWith("\t") || lines.get(0).startsWith("#")) {
				if (condition)
					parseLine();
				else
					lines.remove(0);
			}
		}
		// Unknown
		else
			throw new InterpretingException("Unknown command '" + line + "'");
	}// parseLine()

	/**
	 * Parses the passed condition, and returns true or false depending on the
	 * condition.
	 * 
	 * @param condition
	 * @return True or false depending on the provided condition.
	 */
	private boolean parseCondition(String condition) throws InterpretingException {
		switch (condition) {
			case "isOnGoal":
				return player.getIsAtGoal();
			case "canMoveU":
				return player.canMove('U');
			case "canMoveD":
				return player.canMove('D');
			case "canMoveL":
				return player.canMove('L');
			case "canMoveR":
				return player.canMove('R');
			default:
				throw new InterpretingException("Unknown condition `" + condition + "`");
		}
	}

}// Interpreter

class InterpretingException extends Exception {
	String messageString;

	InterpretingException() {
		this("");
	}

	InterpretingException(String msg) {
		super(msg);
		messageString = msg;
	}
}