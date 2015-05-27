package dotandboxes.Gui;

import dotandboxes.Game;
import dotandboxes.Models.GameListener;
import dotandboxes.Models.Player;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Caro
 */
public class StatusBar extends JPanel implements GameListener {
    
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
        feldLinks1.setBackground(new Color(0,0,0,0));
        feldLinks1.setEditable(false);
        feldLinks1.setVisible(true);
        feldLinks1.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 12));
        feldLinks2 = new JTextArea("" + player.getScore());
        feldLinks2.setBackground(new Color(0,0,0,0));
        feldLinks2.setEditable(false);
        feldLinks2.setVisible(true);
        feldLinks2.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 12));
        
        //Feld mitte
        JTextArea feldMitte1 = new JTextArea(enemy.getName() + ": ");
        feldMitte1.setBackground(new Color(0,0,0,0));
        feldMitte1.setEditable(false);
        feldMitte1.setVisible(true);
        feldMitte1.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 12));
        feldMitte2 = new JTextArea("" + enemy.getScore());
        feldMitte2.setBackground(new Color(0,0,0,0));
        feldMitte2.setEditable(false);
        feldMitte2.setVisible(true);
        feldMitte2.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 12));
        
        //Feld rechts
        feldRechts = new JTextArea(whosTurn);
        feldRechts.setBackground(new Color(0,0,0,0));
        feldRechts.setEditable(false);
        feldRechts.setVisible(true);
        feldRechts.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 12));

        JPanel unten = new JPanel();
        unten.setLayout(new FlowLayout(FlowLayout.CENTER));
        unten.add(feldLinks1);
        unten.add(feldLinks2);
        unten.add(feldMitte1);
        unten.add(feldMitte2);
        unten.add(feldRechts);  
        
        this.add(unten);
        
        Game.addListener(this);
        this.setVisible(true);
    }
    
    private void getWhosTurn() {
        whosTurn = "It's " + Game.getCurrentPlayer().getName() + "'s Turn";
    }
    
    @Override
    public void gameEvent() {
        getWhosTurn();
        feldLinks2.setText(String.valueOf(player.getScore()));
        feldMitte2.setText(String.valueOf(enemy.getScore()));
        feldRechts.setText(whosTurn);
        
        repaint();
    }
}
