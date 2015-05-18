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
    private Line line;
   
    
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
        setColor();
        
        this.setPreferredSize(new Dimension(x, y));
        this.setMinimumSize(new Dimension(x/2, y/2));
        this.setMaximumSize(new Dimension(x*2, y*2));
        
        this.addMouseListener(new MouseAdapter() {  //MouseListener für jede Linie
            @Override
            public void mouseClicked(MouseEvent e) {
                linePaint();
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
     * Ask the Line wether it is marked or not. Set the color accordingly.
     */
    private void setColor() {
        if(line.getIsMarked()) {
            color = colorPainted;
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
        setColor();
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
        setColor();
        repaint();
    }

    
    /**
     * Draw a line/rectancle with the dimensions x and y and of the color black.
     */
    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(color);
        if (this.getWidth() < this.getHeight()) {
            g.fillRect(this.getWidth()/4, 0, this.getWidth()/2, this.getHeight());
        }
        else {
            g.fillRect(0, this.getHeight()/4, this.getWidth(), this.getHeight()/2);
        }
        
    }
}
