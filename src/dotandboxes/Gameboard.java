package dotandboxes;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Gameboard is the graphical interface of the game Dots and Boxes. It creats a
 * field with the specified number of rows and columns and displays all the
 * visual Parts of the programm.
 * @author Caro
 */
public class Gameboard extends JPanel implements PictureListener {

    private GridBagLayout grid;
    GridBagConstraints gridBag;
    
    
    /**
     * Create a new Gameboard with the specified number of rows and columns.
     * @param rows
     * @param columns 
     */
    public Gameboard(List<List<Box>> list) {
        super();
        this.setBackground(Color.WHITE);
        grid = new GridBagLayout();
        this.setLayout(grid);
        gridBag = new GridBagConstraints();
        createGrid(list);
        LinePicture.addListener(this);
        this.setVisible(true);
    }    
    
    /**
     * Create the GridLayout with the specified number of rows and columns and the size of these.
     * @param rows
     * @param columns 
     */
    private void createGrid(List<List<Box>> list) {
        
        // Setze ersten Dot
        gridBag.gridx = 0;
        gridBag.gridy = 0;
        this.add(new DotPicture(), gridBag);
        
        // Setze erste Spalte mit Lines
        for (int y = 0; y <= list.get(0).size()-1; y++) {
            gridBag.gridy = 2*y+1;
            this.add(new LinePicture(list.get(0).get(y).getLeftLine(), LinePicture.VERTICAL), gridBag);
            gridBag.gridy += 1;
            this.add(new DotPicture(), gridBag);
        }
        
        // Setze erste Zeile
        gridBag.gridy = 0;
        for (int x = 0; x <= list.size()-1; x++) {
            gridBag.gridx = 2*x+1;
            this.add(new LinePicture(list.get(x).get(0).getUpperLine(), LinePicture.HORIZONTAL), gridBag);
            gridBag.gridx += 1;
            this.add(new DotPicture(), gridBag);
        }
        
        // Setze Rest
        for (int x = 1; x <= list.size(); x++) {
            gridBag.gridx = 2*x-1;
            for (int y = 1; y <= list.get(x-1).size(); y++) {
                Box box = list.get(x-1).get(y-1);
                gridBag.gridy = 2*y-1;
                this.add(new BoxPicture(box), gridBag);
                gridBag.gridy++;     // Untere Linie
                this.add(new LinePicture(box.getBottomLine(), LinePicture.HORIZONTAL),gridBag);
                gridBag.gridx++;     // Punkt unten rechts
                this.add(new DotPicture(), gridBag);
                gridBag.gridy--;     // Rechte Linie
                this.add(new LinePicture(box.getRightLine(), LinePicture.VERTICAL), gridBag);
            }
        }
    }        
    
    /**
     * Implements Listener Methods.
     */
    public void pictureEvent() {
        repaint();
    }
    
    public static void main(String[] args) {
        
        ArrayList<List<Box>> list = new ArrayList<>();
        ArrayList<Box> boxes = new ArrayList();
        Box box = new Box();
        boxes.add(box);
        list.add(boxes);
        
        Gameboard game = new Gameboard(list);
        //Gameboard game = new Gameboard(10,10);
        frame.add(game);
        frame.setSize(600, 400);
        frame.setVisible(true);
        
    }
}
