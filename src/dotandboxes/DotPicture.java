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
 *
 * @author Caro
 */
public class DotPicture extends Canvas {
    
    private static final int DIMENSION = 5;
    private static final Color color = Color.BLACK;
    
    public DotPicture() {

    }
    
    private void draw(Graphics g) {
        g.fillOval(DIMENSION/2, DIMENSION/2, DIMENSION, DIMENSION);
        g.setColor(color);
    }
    
    
}
