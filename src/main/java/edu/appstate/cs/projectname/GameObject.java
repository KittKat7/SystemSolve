package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;;
/**
 * An object which represents the objects/characters/entities in the game.
 */
public abstract class GameObject {

	// Whether or not this object is an obstacle, and will block movement.
	protected boolean isObstacle;

	//BufferedImage object to store image objects
	protected BufferedImage image;

	/**
	 * Constructor for GameObject
	 * 
	 * @param isObstacle Whether this object is an obstacle
	 */
	GameObject(boolean isObstacle) {
		this.isObstacle = isObstacle;
		
	}//GameObject

	GameObject()
	{
		this.isObstacle = false;
	}

	/**
	 * Returns the isObstacle flag. If isObstacle, the player cannot traverse this area.
	 * 
	 * @return A bool flag marking whether this object can be traversed.
	 */
	public boolean getIsObstacle() {
		return isObstacle;
	}//getIsObstacle

	/**
	 * Reads an image file and assigns it to a variable
	 */
	public abstract BufferedImage getImage();

}//GameObject
