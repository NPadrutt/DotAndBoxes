/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


/**
 * The DotPicture is a canvas with the picture of a dot.
 * @author Caro
 */
public class DotPicture extends JPanel {
    
    private static final int DIMENSION = 10;
    private static final Color color = Color.BLACK;
    
    
    public DotPicture() {
        super();
        this.setPreferredSize(new Dimension(DIMENSION, DIMENSION));
        this.setMinimumSize(new Dimension(DIMENSION/2, DIMENSION/2));
        this.setMaximumSize(new Dimension(DIMENSION*2, DIMENSION*2));
    }
    
    
    /**
     * Draw a circle of the size DIMENSION and the Color black.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.setColor(color);
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
    }
}
