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
 * BoxPicture is the visual part of the Box. It fills with the color of a player when finished.
 * @author Caro
 */
public class BoxPicture extends Canvas {
    
    private static final int DIMENSION = 20;
    private Color color = Color.RED;
    
    
    public BoxPicture() {
    super();
    super.setSize(DIMENSION, DIMENSION);
    }
    
    
    /**
     * Draw a square with the size DIMENSION but just filled half and of the color blue.
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(DIMENSION/4, DIMENSION/4, DIMENSION/2, DIMENSION/2);
        g.setColor(color);
    }
}
