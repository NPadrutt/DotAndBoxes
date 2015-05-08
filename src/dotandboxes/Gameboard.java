/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Gameboard is the graphical interface of the game Dots and Boxes. It creats a
 * field with the specified number of rows and columns and displays all the
 * visual Parts of the programm.
 * @author Caro
 */
public class Gameboard extends JPanel{

    
    private int rows;
    private int columns;
    private GridBagLayout grid;
    GridBagConstraints gridBag;
    
    
    /**
     * Create a new Gameboard with the specified number of rows and columns.
     * @param rows
     * @param columns 
     */
    public Gameboard(int rows, int columns) {
        super();
        this.rows = rows;
        this.columns = columns;
        this.setBackground(Color.WHITE);
        grid = new GridBagLayout();
        this.setLayout(grid);
        gridBag = new GridBagConstraints();
        createGrid();
        this.setVisible(true);
    }
    
    
    /**
     * Create the GridLayout with the specified number of rows and columns and the size of these.
     * @param rows
     * @param columns 
     */
    private void createGrid() {
        for (int y = 0; y <= (2*columns); y++) {
            for (int x = 0; x <= (2*rows); x++) {
                gridBag.gridy = y;
                gridBag.gridx = x;
                if ((y%2 == 0) && (x%2 == 0)) {
                    gridBag.fill = GridBagConstraints.CENTER;
                    this.add(new DotPicture(), gridBag);
                }
                else if ((y%2 == 0) && (x%2 != 0)) {
                    gridBag.fill = GridBagConstraints.HORIZONTAL;
                    this.add(new LinePicture(LinePicture.HORIZONTAL), gridBag);
                }
                else if ((y%2 != 0) && (x%2 == 0)) {
                    gridBag.fill = GridBagConstraints.VERTICAL;
                    this.add(new LinePicture(LinePicture.VERTICAL), gridBag);
                }
                else {
                    gridBag.fill = GridBagConstraints.BOTH;
                    this.add(new BoxPicture(), gridBag);
                }
            }
        }
    }
    
    
    

    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        Gameboard game = new Gameboard(10,10);
        frame.setContentPane(game);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
