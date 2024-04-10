package edu.appstate.cs.projectname;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class to get and read the text file containing the level instructions.
 */
public class ReadInstructions {

	// String that contains the repeated parts of the path
	private static String filePathStr = ".//src//main//java//edu//appstate//cs//projectname//Instructions";

	/**
	 * Method that takes the level as an int and
	 * loads the corresponding text file then
	 * returns it as a string
	 * 
	 * @param level level the player is on as an int
	 * @return returns string read from file
	 */
	public static String readFile(String level) {
		try {
			String output = "";
			List<String> lines = Files.readAllLines(Paths.get(filePathStr + "//level" + level + "Instr.txt"));
			for (String str : lines)
				output += str + "\n";
			return output;
		} catch (IOException e) {
			return "File Not Found";
		}
	}

}
