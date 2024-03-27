package edu.appstate.cs.projectname;

/**
 * An object which represents the objects/characters/entities in the game.
 */
public abstract class GameObject {

	// Whether or not this object is an obstacle, and will block movement.
	private boolean isObstacle;

	/**
	 * Constructor for GameObject
	 * 
	 * @param isObstacle Whether this object is an obstacle
	 */
	GameObject(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}//GameObject

	/**
	 * Returns the isObstacle flag. If isObstacle, the player cannot traverse this area.
	 * 
	 * @return A bool flag marking whether this object can be traversed.
	 */
	public boolean getIsObstacle() {
		return isObstacle;
	}//getIsObstacle
}//GameObject
