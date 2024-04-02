package edu.appstate.cs.projectname;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
	private static Interpreter interpreter;

	/**
	 * A factory that returns the interpreter instance, or makes a new instance if
	 * one does not exist.
	 * 
	 * @return The interpreter instance.
	 */
	public static Interpreter getInterpreter() {
		if (interpreter == null)
			interpreter = new Interpreter();
		return interpreter;
	}// getInterpreter()

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
		for (String line : lines) {

		}
	}// parse(String)

	/**
	 * Parses a single command. Returns an empty string or an error message if one
	 * is thrown.
	 * 
	 * @param line The command to parse
	 * @return Either an empty string, or an error message
	 */
	private String parseLine(String line) {
		if (line == "moveUp")
			; // TODO: move up
		else if (line == "moveLeft")
			; // TODO: move left
		else if (line == "moveRight")
			; // TODO: move right
		else if (line == "moveDown")
			; // TODO: move down
		return "";
	}// parseLine()

}// Interpreter
