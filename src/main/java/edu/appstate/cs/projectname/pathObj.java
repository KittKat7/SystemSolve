package edu.appstate.cs.projectname;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
     * Overrides GameObject get image. 
     * Reads png file and returns the image
     * @return returns image read for path object
     */
    @Override
    public BufferedImage getImage() {
        try {
            File wall = new File
                (".\\src\\main\\java\\edu\\appstate\\cs\\projectname\\BackGroundImages\\path.png");
            return ImageIO.read(wall);
        } catch (IOException e) {
            return null;
        } 
    }
}
