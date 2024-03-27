package edu.appstate.cs.projectname;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Object representing the wall
 */
public class wallObj extends GameObject {

    /*
     * Constructor for wallObj
     */
    public wallObj(){
        super(true);
        super.image = this.getImage();
    }

    /**
     * Overrides GameObject get image. 
     * Reads png file and returns the image
     * @return returns image read for wall object
     */
    @Override
    public BufferedImage getImage() {
        try {
            File wall = new File
                (".src\\main\\java\\edu\\appstate\\cs\\projectname\\BackGroundImages\\wall.png");
            return ImageIO.read(wall);
        } catch (IOException e) {
            return null;
        } 
    }
}
