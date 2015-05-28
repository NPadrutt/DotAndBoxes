package dotandboxes.Gui;

import dotandboxes.Game;
import dotandboxes.Gameboard;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author lmal
 */
public class DotAndBoxes extends JFrame {    
    
    static CreateGameDialog dialog;
    
    public DotAndBoxes() {
        super("Dots and Boxes");
        GUI();
    }
    
    private void GUI() {        
        dialog = new CreateGameDialog(this);
        dialog.setVisible(true);
        createGame ();
    }
    
    public void createGame (){        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        Game game = new Game(dialog.getGameboardSizeVertical(),dialog.getGameboardSizeHorizontal(),dialog.getPlayerName(),dialog.getGamemode());
        Gameboard gameboard = new Gameboard(game.getList());

        this.add(gameboard, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);

        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.addActionListener((ActionEvent e) -> {
            new DotAndBoxes();
        });
        gameMenu.add(newGameMenuItem);

        // Exit
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);            
        });
        gameMenu.add(exitMenuItem);
        this.setJMenuBar(menuBar);

        // status bar
        StatusBar statusBarPanel = new StatusBar(Game.getPlayer(), Game.getEnemy());
        this.add(statusBarPanel, BorderLayout.SOUTH);
        
        this.pack();
        this.setVisible(true);       
    }
    
    public static void main(String[] args){            
       new DotAndBoxes();        
    }
}
