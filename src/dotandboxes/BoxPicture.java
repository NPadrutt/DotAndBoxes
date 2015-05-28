/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import dotandboxes.Game;
import dotandboxes.Models.Box;
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
    private static final Color colorBlank = Color.YELLOW;
    private static final Color colorPlayer = Color.RED;
    private static final Color colorEnemy = Color.BLUE;
    private static final int DIMENSION = 50;
    private Color color;
    private Box box;
    
    
    public BoxPicture(Box box) {
    super();
    this.box = box;
    setColor();
    this.setPreferredSize(new Dimension(DIMENSION, DIMENSION));
    this.setMinimumSize(new Dimension(DIMENSION/2, DIMENSION/2));
    this.setMaximumSize(new Dimension(DIMENSION*2, DIMENSION*2));
    
    }
    
    
    /**
     * Ask the Box wether it is marked or not. Set the color accordingly.
     */
    private void setColor() {
        if(box.isBoxFull()) {
            if(box.getMarkedBy() == Game.getPlayer()) {
                color = colorPlayer;
            }
            else {
                color = colorEnemy;
            }
        }
        else {
            color = colorBlank;
        }
    }
    
    /**
     * Draw a square with the size DIMENSION but just filled half and of the color blue.
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        setColor();
        g.setColor(color);
        g.fillRect(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);
    }
}
