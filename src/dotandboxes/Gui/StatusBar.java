/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Caro
 */
public class StatusBar extends JPanel {
    
    int scorePlayer;
    int scoreEnemy;
    String whosTurn;
    
    public StatusBar(String namePlayer, String nameEnemy) {
        super();
        GridLayout layout = new GridLayout();
        layout.setColumns(3);
        this.setLayout(layout);
        scorePlayer = 0;
        scoreEnemy = 0;
        getWhosTurn();
        
        //Feld links
        JTextArea feldLinks1 = new JTextArea(namePlayer + ": ");
        JTextArea feldLinks2 = new JTextArea("" + scorePlayer);
        
        //Feld mitte
        JTextArea feldMitte1 = new JTextArea(nameEnemy + ": ");
        JTextArea feldMitte2 = new JTextArea("" + scoreEnemy);
        
        //Feld rechts
        JTextArea feldRechts = new JTextArea(whosTurn);
        
        
        this.setVisible(true);
        
        
    }
    
    private void getWhosTurn() {
        
    }
}
