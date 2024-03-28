/**
 * Board.java
 * (c) Team Beedrill 2024-03-27
 * Please refer to the license file
 */
package edu.appstate.cs.projectname;

public class Board {
	
	/* row: y, col: x
	[[a,b,c],
	 [a,b,c],
	 [a,b,c]]
	 */
	private GameObject[][] board;

	Board() {
		// TODO Constructor
	}//Board()

	/**
	 * Returns the game object at the specified position.
	 *
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return A game object at the specified position, or null if no object is found
	 */
	public GameObject getObject(int x, int y) {
		return board[y][x];
	}//getObject(int, int)

	public boolean canMove(int x, int y) {
		return getObject(x, y) == null || !getObject(x, y).getIsObstacle();
	}//canMove(int, int
	
}//Board
