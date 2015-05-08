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
 * The DotPicture is a canvas with the picture of a line. The line can be
 * horizontal or vertical.
 * @author Caro
 */
public class LinePicture extends Canvas {
    
    public static final String VERTICAL = "vertical";
    public static final String HORIZONTAL = "horizontal";
    private static final Color color = Color.BLUE;
    private static final int HEIGHT = 5;
    private static final int WIDTH = 20;
    private int x;
    private int y;
   
    
    public LinePicture (String direction) {
        super();
        if (direction == VERTICAL) {
            x = HEIGHT;
            y = WIDTH;
        }
        else if (direction == HORIZONTAL) {
            x = WIDTH;
            y = HEIGHT;
        }
        super.setSize(x, y);
    }

    
    /**
     * Draw a line/rectancle with the dimensions x and y and of the color black.
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(0, 0, x, y);
        g.setColor(color);
    }
}
