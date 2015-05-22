/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Gui;

import dotandboxes.LinePicture;
import static dotandboxes.LinePicture.listeners;
import dotandboxes.Models.Box;
import dotandboxes.Models.BoxListener;
import dotandboxes.PictureListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * BoxPicture is the visual part of the Box. It fills with the color of a player when finished.
 * @author Caro
 */
public class BoxPicture extends JPanel implements PictureListener{
    
    public static ArrayList<BoxListener> listeners = new ArrayList<>();
    private static final Color colorBlank = Color.YELLOW;
    private static final Color colorPainted = Color.RED;
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
    LinePicture.addListener(this);
    
    }
    
    
    /**
     * Ask the Box wether it is marked or not. Set the color accordingly.
     */
    private void setColor() {
        if(box.isBoxFull()) {
            color = colorPainted;
        }
        else {
            color = colorBlank;
        }
    }
    
    
    public static void addListener(BoxListener toAdd) {
        listeners.add(toAdd);
    }
    
    
    public void pictureEvent() {
        if((color == colorBlank)&&(box.isBoxFull())) {
            for (BoxListener hl : listeners)
            hl.boxEvent(true);
        }
        else {
            for (BoxListener hl : listeners)
            hl.boxEvent(false);
        }
        repaint();
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
