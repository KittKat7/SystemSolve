package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;

/**
 * Object representing the path
 */
public class pathObj extends GameObject{

    /**
     * Constructor for pathObj
     */
    public pathObj(){
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
