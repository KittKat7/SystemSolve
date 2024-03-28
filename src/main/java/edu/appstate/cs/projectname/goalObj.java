package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;

/**
 * Object representing the end goal
 */
public class goalObj extends GameObject{
    /**
     * constructor for goalObj
     */
    public goalObj(){
        super(false);
        super.image = this.getImage();
    }

    /**
     * Reads png file and returns the image
     * @return returns image read for goal object
     */
    public BufferedImage getImage() {
        return getImage("goal.png");
    }
}
