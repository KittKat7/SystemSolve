package edu.appstate.cs.codequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Interpreter {
	private static final HashSet<String> KEYWORDS = new HashSet<String>(Arrays.asList(
			"var", "while", "moveUp", "moveDown", "moveLeft", "moveRight"));
	private PlayerObject player;

	HashMap<String, Integer> vars = new HashMap<String, Integer>();

	public Interpreter(PlayerObject player) {
		this.player = player;
	}

	/**
	 * Parses the string param, and returns a string with the completion/error
	 * message. Tries to parse and run all the provided commands. If an error
	 * occurs, the message will be returned.
	 * 
	 * @param str The command/script the player entered.
	 * @return The completion/error message as a result of parsing the string.
	 */
	public void parse(String str) {
		String[] lines = str.split("\n");
		try {
			for (String line : lines) {
				parseLine(line);
			}
		} catch (InterpretingException e) {
			System.out.println("An exception in the code was encountered.");
			System.out.println(e.getMessage());
		}
	}// parse(String)

	/**
	 * Parses a single command. Returns an empty string or an error message if one
	 * is thrown.
	 * 
	 * @param line The command to parse
	 * @return Either an empty string, or an error message
	 */
	private void parseLine(String line) throws InterpretingException {
		String[] parts = line.split(" ");
		// Variable detetion
		if (parts[0] == "var") {
			if (KEYWORDS.contains(parts[1]))
				throw new InterpretingException("Trying to use keyword as variable name '" + parts[1] + "'");
			else if (vars.keySet().contains(parts[1]))
				throw new InterpretingException("Variable " + parts[1]);
			else
				vars.put(parts[1], Integer.parseInt(parts[2]));
		} else if (vars.keySet().contains(parts[0]))
			; // TODO: modifying var
		else if (line == "moveUp")
			player.move("up");
		else if (line == "moveLeft")
			player.move("left");
		else if (line == "moveRight")
			player.move("right");
		else if (line == "moveDown")
			player.move("down");
		else
			throw new InterpretingException("Unknown command '" + line + "'");
	}// parseLine()

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