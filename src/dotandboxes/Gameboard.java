/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javax.swing.JPanel;

/**
 *
 * @author Caro
 */
public class Gameboard extends JPanel{

    
    private int rows;
    private int columns;
    private GridBagLayout grid;
    
    
    /**
     * Create a new Gameboard with the specified number of rows and columns.
     * @param rows
     * @param columns 
     */
    public Gameboard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        createGrid(rows, columns);
        this.setLayout(grid);
        this.setVisible(true);
    }
    
    
    /**
     * Create the GridLayout with the specified number of rows and columns and the size of these.
     * @param rows
     * @param columns 
     */
    private void createGrid(int rows, int columns) {
        grid = new GridBagLayout();
        GridBagConstraints gridBag = new GridBagConstraints();
        for (int i = 0; i <= (2*columns); i++) {
            for (int j = 0; j <= (2*rows); j++) {
                gridBag.gridy = i;
                gridBag.gridx = j;
                if ((i%2 == 0) && (j%2 == 0)) {
                    this.add(new DotPicture(), gridBag);
                }
                else if ((i%2 == 0) && (j%2 != 0)) {
                    this.add(new LinePicture(LinePicture.VERTICAL), gridBag);
                }
                else {
                    this.add(new BoxPicture(), gridBag);
                }
            }
        }
    }
    
}
