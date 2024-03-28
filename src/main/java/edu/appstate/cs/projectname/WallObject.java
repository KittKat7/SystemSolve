package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;

/**
 * Object representing the wall
 */
public class WallObject extends GameObject {

	/*
	 * Constructor for wallObj
	 */
	public WallObject(){
		super(true);
		super.image = this.getImage();
	}

	/**
	 * Reads png file and returns the image
	 * @return returns image read for wall object
	 */
	public BufferedImage getImage() {
		return getImage("wall.png");
	}
}
