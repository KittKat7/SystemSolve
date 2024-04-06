package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;

/**
 * Object representing the player.
 */
public class PlayerObject extends GameObject {

	// Players current x & y position.
	private int x;
	private int y;

	// Reference to the game board.
	private Board board; 

	/**
	 * Constructor for playerObject
	 * 
	 * @param board The game board for the player.
	 * @param StartX The initial x-coordinate of the player.
	 * @param StartY the initial y-coordinate of the player.
	 */
	public PlayerObject(Board board, int StartX, int StartY){
		super(false);
		super.image = PlayerObject.getImage();
		this.board = board;
		this.x = StartX;
		this.y = StartY;
	}

	/**
	 *  Moves the player in the specified direction on the game board.
	 * 
	 * 	@param dir The Direction in which the player should move in.
	 */
	public void move(String dir) {
		switch (dir) {
			case "up":
				if (y > 0 && board.canMove(x, y - 1)) {
					y--;
				}
				break;
			case "down":
				if (y < board.getHeight() - 1 && board.canMove(x, y + 1)) {
					y++;
				}
				break;
			case "left":
				if (x > 0 && board.canMove(x - 1, y)) {
					x--;
				}
				break;
			case "right":
				if (x < board.getWidth() - 1 && board.canMove(x + 1, y)) {
					x++;
				}
				break;
		}
	}

	/**
	 * Reads png file and returns the image
	 * @return returns image read for player object
	 */
	public static BufferedImage getImage() {
		return getImage("player.png");
	}
}



