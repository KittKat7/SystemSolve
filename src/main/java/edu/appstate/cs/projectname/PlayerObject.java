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
		super.image = this.getImage();
		this.board = board;
		this.x = StartX;
		this.y = StartY;
	}

	/**
	 * Moves the player upwards on the game board.
	 */
	public void moveUp() {
		if (y > 0 && board.canMove(x, y - 1))
		{
			y--;
		}
	}

	/**
	 * Moves the player down on the game board.
	 */
	public void moveDown() {
		if (y < board.getHeight() - 1 && board.canMove(x, y + 1))
		{
			y++;
		}
	}

	/**
	 * Moves the player left on the game board.
	 */
	public void moveLeft() {
		if (x > 0 && board.canMove(x - 1, y)) 
		{
			x--;
		}
	}

	/**
	 * Moves the player right on the game board.
	 */
	public void moveRight() {
		if (x < board.getWidth() - 1 && board.canMove(x + 1, y))
		{
			x++;
		}
	}

	/**
	 * Reads png file and returns the image
	 * @return returns image read for player object
	 */
	public BufferedImage getImage() {
		return getImage("player.png");
	}
}



