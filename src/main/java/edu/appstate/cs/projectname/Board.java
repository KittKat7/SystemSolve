/**
 * Board.java
 * (c) Team Beedrill 2024-03-27
 * Please refer to the license file
 */
package edu.appstate.cs.projectname;

public class Board {

	/*
	 * row: y, col: x
	 * [[a,b,c],
	 * [a,b,c],
	 * [a,b,c]]
	 */
	private GameObject[][] board;

	/**
	 * Initialized the board with a width of 16 and height of 12.
	 */
	Board() {
		board = new GameObject[12][16];
	}// Board()

	/**
	 * Initialized the board with input paramaters
	 * for width and height.
	 */
	Board(int x, int y) {
		board = new GameObject[x][y];
	}// Board(int x, int y)

	/**
	 * Returns the width of the board.
	 * 
	 * @return An int width of the board
	 */
	public int getWidth() {
		return board[0].length;
	}// getWidth

	/**
	 * Returns the height of the board.
	 * 
	 * @return An int height of the board
	 */
	public int getHeight() {
		return board.length;
	}// getHeight

	/**
	 * Returns the game object at the specified position.
	 *
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return A game object at the specified position, or null if no object is
	 *         found
	 */
	public GameObject getObject(int x, int y) {
		return board[y][x];
	}// getObject(int, int)

	/**
	 * Returns whether or not a specified tile can be moved to. Returns true of the
	 * specified tile
	 * can be moved to, false otherwise.
	 * 
	 * @param x The x coordinate of the specified tile
	 * @param y The y coordinate of the specified tile
	 * @return A boolean representing whether the tile can be moved to
	 */
	public boolean canMove(int x, int y) {
		return getObject(x, y) == null || !getObject(x, y).getIsObstacle();
	}// canMove(int, int

}// Board
