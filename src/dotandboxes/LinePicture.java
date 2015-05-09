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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * The DotPicture is a canvas with the picture of a line. The line can be
 * horizontal or vertical.
 * @author Caro
 */
public class LinePicture extends JPanel {
    
    public static final String VERTICAL = "vertical";
    public static final String HORIZONTAL = "horizontal";
    private static final Color colorBlank = Color.YELLOW;
    private static final Color colorHighlight = Color.RED;
    private static final Color colorPainted = Color.BLACK;
    private static final int HEIGHT = 10;
    private static final int WIDTH = 50;
    private Color color;
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
        color = colorBlank;
        super.setPreferredSize(new Dimension(x, y));
        super.setMinimumSize(new Dimension(x/2, y/2));
        super.setMaximumSize(new Dimension(x*2, y*2));
        this.addMouseListener(new MouseAdapter() {  //MouseListener für jede Linie
            @Override
            public void mouseClicked(MouseEvent e) {
                linePainted();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lineHighlight();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lineNormal();
            }
        });
    }
    
    
    /**
     * Change the color of the line to black.
     */
    private void linePainted() {
        color = colorPainted;
        repaint();
    }
    
    
    /**
     * Highlight the line.
     */
    private void lineHighlight() {
        if(color == colorBlank) {
            color = colorHighlight;
        }
        repaint();
    }
    
    
    /**
     * Reverse highlighting the line.
     */
    private void lineNormal() {
        if(color == colorHighlight) {
            color = colorBlank;
        }
        repaint();
    }

    
    /**
     * Draw a line/rectancle with the dimensions x and y and of the color black.
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        g.setColor(color);
        if (super.getWidth() < super.getHeight()) {
            g.fillRect(super.getWidth()/4, 0, super.getWidth()/2, super.getHeight());
        }
        else {
            g.fillRect(0, super.getHeight()/4, super.getWidth(), super.getHeight()/2);
        }
        
    }
}
