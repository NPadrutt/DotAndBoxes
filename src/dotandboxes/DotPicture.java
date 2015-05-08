/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


/**
 * The DotPicture is a canvas with the picture of a dot.
 * @author Caro
 */
public class DotPicture extends Canvas {
    
    private static final int DIMENSION = 5;
    private static final Color color = Color.BLACK;
    
    
    public DotPicture() {
        super();
        super.setSize(DIMENSION, DIMENSION);
    }
    
    
    /**
     * Draw a circle of the size DIMENSION and the Color black.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, DIMENSION, DIMENSION);
    }
    
    
}
