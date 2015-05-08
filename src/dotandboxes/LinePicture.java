/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.awt.Canvas;

/**
 *
 * @author Caro
 */
public class LinePicture extends Canvas {
    
    public static final String VERTICAL = "vertical";
    public static final String HORIZONTAL = "horizontal";
    private static final int HEIGHT = 5;
    private static final int WIDTH = 20;
    private int x;
    private int y;
   
    
    public LinePicture (String direction) {
        if (direction == VERTICAL) {
            x = HEIGHT;
            y = WIDTH;
        }
        else if (direction == HORIZONTAL) {
            x = WIDTH;
            y = HEIGHT;
        }
    }

    
}
