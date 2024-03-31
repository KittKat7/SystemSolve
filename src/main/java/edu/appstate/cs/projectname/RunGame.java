package edu.appstate.cs.projectname;

import javax.swing.*;

/**
 * Main sets up and displays the JFrame
 */
public class RunGame{	
	public static void main( String[] args ){

		JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Code Quest");
        
		DisplayBoard  game = new DisplayBoard();
        window.add(game);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}
}
