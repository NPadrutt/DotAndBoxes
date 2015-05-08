/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * The DotPicture is a canvas with the picture of a line. The line can be
 * horizontal or vertical.
 * @author Caro
 */
public class LinePicture extends JPanel {
    
    public static final String VERTICAL = "vertical";
    public static final String HORIZONTAL = "horizontal";
    private static final Color color = Color.BLUE;
    private static final int HEIGHT = 5;
    private static final int WIDTH = 50;
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
        super.setPreferredSize(new Dimension(x, y));
        super.setMinimumSize(new Dimension(x/2, y/2));
        super.setMaximumSize(new Dimension(x*2, y*2));
    }

    
    /**
     * Draw a line/rectancle with the dimensions x and y and of the color black.
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.setColor(color);
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        
    }
}
