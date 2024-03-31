package edu.appstate.cs.projectname;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Class to display game images onto a JPanel
 */
public class DisplayBoard extends JPanel{

    //Sets values needed for screen display
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile size
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels aka 16 48x48 tiles
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels aka 12 48x48 tiles
    
    //test board
    BufferedImage[] image;
    public GameObject[][] testBoard = new GameObject[maxScreenRow][maxScreenCol];


    //Constructor that sets JPanel Parameters
    DisplayBoard(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    /**
     * Method to initialize and fill the 
     * testBoard array with images
     */
    public void fillArray(){

        for(int i = 0; i < maxScreenRow; i++){
            for(int j = 0; j < maxScreenCol; j++){
                testBoard[i][j] = new GameObject();
                testBoard[i][j].image = WallObject.getImage();
            } 
        }

        
        testBoard[11][7].image = PlayerObject.getImage();
        testBoard[10][7].image = PathObject.getImage();
        testBoard[9][7].image = PathObject.getImage();
        testBoard[8][7].image = PathObject.getImage();
        testBoard[8][6].image = PathObject.getImage();
        testBoard[7][6].image = PathObject.getImage();
        testBoard[6][6].image = PathObject.getImage();
        testBoard[5][6].image = PathObject.getImage();
        testBoard[4][6].image = PathObject.getImage();
        testBoard[4][5].image = PathObject.getImage();
        testBoard[4][4].image = PathObject.getImage();
        testBoard[3][3].image = PathObject.getImage();
        testBoard[2][3].image = PathObject.getImage();
        testBoard[2][2].image = PathObject.getImage();
        testBoard[1][2].image = PathObject.getImage();
        testBoard[0][2].image = GoalObject.getImage();

    }

    /**
     * method to draw images onto the entire screen set by 
     * maxScreenWidth and maxScreenHeight
     * @param g2
     */
    public void draw(Graphics2D g2)
    {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        fillArray();
        
        while(col < maxScreenCol && row < maxScreenRow)
        {
            g2.drawImage(testBoard[row][col].image, x, y, tileSize, tileSize, null);
            col++;
            x += tileSize;
            
            if(col == maxScreenCol)
            {
                col = 0;
                x = 0;
                row++;
                y += tileSize;
            }
        }
    }

    /**
     * Method to actually draw and deal with images using
     * Graphics2D to paint the images onto the JPanel
     */
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        fillArray();

        draw(g2);

        g2.dispose();
    }

    
}
