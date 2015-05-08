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
 * BoxPicture is the visual part of the Box. It fills with the color of a player when finished.
 * @author Caro
 */
public class BoxPicture extends JPanel {
    
    private static final int DIMENSION = 50;
    private Color color = Color.RED;
    
    
    public BoxPicture() {
    super();
    super.setPreferredSize(new Dimension(DIMENSION, DIMENSION));
    super.setMinimumSize(new Dimension(DIMENSION/2, DIMENSION/2));
    super.setMaximumSize(new Dimension(DIMENSION*2, DIMENSION*2));
    }
    
    
    /**
     * Draw a square with the size DIMENSION but just filled half and of the color blue.
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.setColor(color);
        g.fillRect(super.getWidth()/4, super.getHeight()/4, super.getWidth()/2, super.getHeight()/2);
    }
}
