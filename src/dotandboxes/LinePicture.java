/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import dotandboxes.Models.Line;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The DotPicture is a canvas with the picture of a line. The line can be
 * horizontal or vertical.
 * @author Caro
 */
public class LinePicture extends JPanel {
    
    public static final String VERTICAL = "vertical";
    public static final String HORIZONTAL = "horizontal";
    public static ArrayList<PictureListener> listeners = new ArrayList<>();
    private static final Color colorBlank = Color.YELLOW;
    private static final Color colorHighlight = Color.RED;
    private static final Color colorPainted = Color.BLACK;
    private static final int HEIGHT = 10;
    private static final int WIDTH = 50;
    private Color color;
    private int x;
    private int y;
    private Line line;
    private Boolean highlight;
   
    
    public LinePicture (Line line, String direction) {
        super();
        this.line = line;
        if (direction.equals(VERTICAL)) {
            x = HEIGHT;
            y = WIDTH;
        }
        else if (direction.equals(HORIZONTAL)) {
            x = WIDTH;
            y = HEIGHT;
        }
        highlight = false;
        setColor();
        
        this.setPreferredSize(new Dimension(x, y));
        this.setMinimumSize(new Dimension(x/2, y/2));
        this.setMaximumSize(new Dimension(x*2, y*2));
        
        this.addMouseListener(new MouseAdapter() {  //MouseListener für jede Linie
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Game.isPlayersTurn()) {
                    linePaint();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Game.isPlayersTurn()) {
                    lineHighlight();
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lineNormal();
            }
        });
    }
        
    /**
     * Ask the Line wether it is marked or not. Set the color accordingly.
     */
    private void setColor() {
        if(line.getIsMarked()) {
            color = colorPainted;
        }
        else if (highlight) {
            color = colorHighlight;
        }
        else {
            color = colorBlank;
        }
    }    
    
    /**
     * Change the color of the line to black.
     */
    private void linePaint() {
        line.setIsMarked(true);
        repaint();
        pictureEvent();
    }
    
    
    /**
     * Highlight the line.
     */
    private void lineHighlight() {
        if(color == colorBlank) {
            highlight = true;
        }
        repaint();
    }
    
    
    /**
     * Reverse highlighting the line.
     */
    private void lineNormal() {
        highlight = false;
        repaint();
    }
    
    
    /**
     * Implement PictureEvent Methods.
     */
    public static void addListener(PictureListener toAdd) {
        listeners.add(toAdd);
    }

    public static void pictureEvent() {
        for (PictureListener hl : listeners)
            hl.pictureEvent();
    }

    
    /**
     * Draw a line/rectancle with the dimensions x and y and of the color black.
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        setColor();
        g.setColor(color);
        if (this.getWidth() < this.getHeight()) {
            g.fillRect(this.getWidth()/4, 0, this.getWidth()/2, this.getHeight());
        }
        else {
            g.fillRect(0, this.getHeight()/4, this.getWidth(), this.getHeight()/2);
        }
        
    }
}
