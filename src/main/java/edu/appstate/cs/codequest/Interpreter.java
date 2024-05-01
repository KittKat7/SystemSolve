package edu.appstate.cs.codequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
		String line = lines.get(0).trim();
		lines.remove(0);
		// Comment
		if (line.startsWith("#") || line.isEmpty())
			return;
		// Admin commands
		else if (line.startsWith("adminLevelCompleteTrue")) {
			Level.getLevel().setComplete(true);
		}
		// Movement
		else if (line.startsWith("move")) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
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
			boolean condition = parseCondition(
					line.trim().substring(0, line.trim().length() - 1).substring("if ".length()));
			while (!lines.get(0).trim().startsWith("fi")) {
				if (condition)
					parseLine();
				else
					lines.remove(0);
			}
			lines.remove(0);
		}
		// While loop
		else if (line.startsWith("while ")) {
			// Remove the 'if ' and the ':'
			String conditionStr = line.trim().substring(0, line.trim().length() - 1).substring("while ".length());
			ArrayList<String> loopedcode = new ArrayList<String>();
			while (!lines.get(0).startsWith("elihw")) {
				loopedcode.add(lines.get(0));
				lines.remove(0);
			}
			System.out.println("HELLO WORLD");
			while (parseCondition(conditionStr)) {
				lines.addAll(0, loopedcode);
				System.out.println(lines);

				while (true) {
					if (lines.get(0).trim().startsWith("elihw"))
						break;
					parseLine();
				}
			}
			lines.remove(0);
		}
		// Unknown
		else
			throw new InterpretingException("Unknown command '" + line + "'");
	}// parseLine()

	/**
	 * Parses the passed condition, and returns true or false depending on the
	 * condition.
	 * 
	 * @param str
	 * @return True or false depending on the provided condition.
	 */
	private boolean parseCondition(String str) throws InterpretingException {
		boolean condition = false;
		boolean negated = str.startsWith("!");
		if (negated)
			str = str.substring(1);
		switch (str) {
			case "isOnGoal":
				condition = player.getIsAtGoal();
				break;
			case "canMoveU":
				condition = player.canMove('U');
				break;
			case "canMoveD":
				condition = player.canMove('D');
				break;
			case "canMoveL":
				condition = player.canMove('L');
				break;
			case "canMoveR":
				condition = player.canMove('R');
				break;
			default:
				throw new InterpretingException("Unknown condition `" + str + "`");
		}
		if (!negated)
			return condition;
		else
			return !condition;
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