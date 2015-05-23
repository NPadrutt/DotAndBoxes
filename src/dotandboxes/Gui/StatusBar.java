/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Gui;

import dotandboxes.Enemy;
import dotandboxes.Game;
import dotandboxes.Models.EnemyListener;
import dotandboxes.Models.Player;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Caro
 */
public class StatusBar extends JPanel implements EnemyListener {
    
    Player player;
    Player enemy;
    String whosTurn;
    JTextArea feldLinks2;
    JTextArea feldMitte2;
    JTextArea feldRechts;
    
    public StatusBar(Player player, Player enemy) {
        super();
        LayoutManager layout = new GridLayout(1, 3);
        this.setLayout(layout);
        this.player = player;
        this.enemy = enemy;
        getWhosTurn();
        
        //Feld links
        JTextArea feldLinks1 = new JTextArea(player.getName() + ": ");
        feldLinks1.setBackground(Color.WHITE);
        feldLinks1.setEditable(false);
        feldLinks1.setVisible(true);
        feldLinks1.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        feldLinks2 = new JTextArea("" + player.getScore());
        feldLinks2.setBackground(Color.WHITE);
        feldLinks2.setEditable(false);
        feldLinks2.setVisible(true);
        feldLinks2.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        
        //Feld mitte
        JTextArea feldMitte1 = new JTextArea(enemy.getName() + ": ");
        feldMitte1.setBackground(Color.WHITE);
        feldMitte1.setEditable(false);
        feldMitte1.setVisible(true);
        feldMitte1.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        feldMitte2 = new JTextArea("" + enemy.getScore());
        feldMitte2.setBackground(Color.WHITE);
        feldMitte2.setEditable(false);
        feldMitte2.setVisible(true);
        feldMitte2.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        
        //Feld rechts
        feldRechts = new JTextArea(whosTurn);
        feldRechts.setBackground(Color.WHITE);
        feldRechts.setEditable(false);
        feldRechts.setVisible(true);
        feldRechts.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20));
        
        JPanel links = new JPanel();
        links.setLayout(new FlowLayout(FlowLayout.LEFT));
        links.add(feldLinks1);
        links.add(feldLinks2);
        links.setBackground(Color.WHITE);
        
        JPanel mitte = new JPanel();
        mitte.setLayout(new FlowLayout(FlowLayout.LEFT));
        mitte.add(feldMitte1);
        mitte.add(feldMitte2);
        mitte.setBackground(Color.WHITE);
        
        JPanel rechts = new JPanel();
        rechts.setLayout(new FlowLayout(FlowLayout.CENTER));
        rechts.add(feldRechts);
        rechts.setBackground(Color.WHITE);
        
        this.add(links);
        this.add(mitte);
        this.add(rechts);
        
        Enemy.addListener(this);
        this.setVisible(true);
    }
    
    private void getWhosTurn() {
        whosTurn = "It's " + Game.getCurrentPlayer().getName() + "'s Turn";
    }
    
    @Override
    public void enemyEvent() {
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        getWhosTurn();
        feldLinks2.setText("" + player.getScore());
        feldMitte2.setText("" + enemy.getScore());
        feldRechts.setText(whosTurn);
        super.paintComponents(g);
    }
}
