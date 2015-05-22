/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Gui;

import dotandboxes.Game;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
        this.setLayout(layout);
        scorePlayer = 0;
        scoreEnemy = 0;
        getWhosTurn();
        
        //Feld links
        JTextArea feldLinks1 = new JTextArea(namePlayer + ": ");
        feldLinks1.setBackground(Color.WHITE);
        feldLinks1.setPreferredSize(new Dimension(100, 50));
        feldLinks1.setEditable(false);
        feldLinks1.setVisible(true);
        feldLinks1.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        JTextArea feldLinks2 = new JTextArea("" + scorePlayer);
        feldLinks2.setBackground(Color.WHITE);
        feldLinks2.setPreferredSize(new Dimension(50, 50));
        feldLinks2.setEditable(false);
        feldLinks2.setVisible(true);
        feldLinks2.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        
        //Feld mitte
        JTextArea feldMitte1 = new JTextArea(nameEnemy + ": ");
        feldMitte1.setBackground(Color.WHITE);
        feldMitte1.setPreferredSize(new Dimension(100, 50));
        feldMitte1.setEditable(false);
        feldMitte1.setVisible(true);
        feldMitte1.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        JTextArea feldMitte2 = new JTextArea("" + scoreEnemy);
        feldMitte2.setBackground(Color.WHITE);
        feldMitte2.setPreferredSize(new Dimension(50, 50));
        feldMitte2.setEditable(false);
        feldMitte2.setVisible(true);
        feldMitte2.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        
        //Feld rechts
        JTextArea feldRechts = new JTextArea(whosTurn);
        feldRechts.setBackground(Color.WHITE);
        feldRechts.setPreferredSize(new Dimension(100, 50));
        feldRechts.setEditable(false);
        feldRechts.setVisible(true);
        feldRechts.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        
        Container links = new Container();
        links.setLayout(new GridLayout());
        links.add(feldLinks1);
        links.add(feldLinks2);
        
        Container mitte = new Container();
        mitte.add(feldMitte1);
        mitte.add(feldMitte2);
        
        this.add(links);
        this.add(mitte);
        this.add(feldRechts);
        
        
        this.setVisible(true);
    }
    
    private void getWhosTurn() {
        whosTurn = "It's " + Game.currentPlayer.getName() + "'s Turn";
    }
}
