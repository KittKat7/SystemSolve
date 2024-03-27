package edu.appstate.cs.projectname;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
     * Overrides GameObject get image. 
     * Reads png file and returns the image
     * @return returns image read for goal object
     */
    @Override
    public BufferedImage getImage() {
        try {
            File wall = new File
                (".\\src\\main\\java\\edu\\appstate\\cs\\projectname\\BackGroundImages\\goal.png");
            return ImageIO.read(wall);
        } catch (IOException e) {
            return null;
        } 
    }
}
