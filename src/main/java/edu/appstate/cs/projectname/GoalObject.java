package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;

/**
 * Object representing the end goal
 */
public class GoalObject extends GameObject{
	/**
	 * constructor for goalObj
	 */
	public GoalObject(){
		super(false);
		super.image = GoalObject.getImage();
	}

	/**
	 * Reads png file and returns the image
	 * @return returns image read for goal object
	 */
	public static BufferedImage getImage() {
		return getImage("goal.png");
	}
}
