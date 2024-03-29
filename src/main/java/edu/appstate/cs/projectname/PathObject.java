package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;

/**
 * Object representing the path
 */
public class PathObject extends GameObject{

	/**
	 * Constructor for pathObj
	 */
	public PathObject(){
		super(false);
		super.image = this.getImage();
	}

	/**
	 * Reads png file and returns the image
	 * @return returns image read for path object
	 */
	public BufferedImage getImage() {
		return getImage("path.png");
	}
}