/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dotandboxes.CreateGameDialog;
import dotandboxes.Game;
import dotandboxes.Gameboard;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

    
    public  void createGame (){        
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout thisLayout = new BorderLayout();
        this.setLayout(thisLayout); 

        Game game = new Game(dialog.getGameboardSize(),dialog.getGameboardSize(),dialog.getPlayerName(),dialog.getGamemode());
        Gameboard gameboard = new Gameboard(game.getList());

        this.add(gameboard, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);


        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        gameMenu.add(newGameMenuItem);

        // Exit
        //JMenuItem exitMenuItem = new JMenuItem("Exit");
        //exitMenuItem.addActionListener((ActionListener) frame);
        //gameMenu.add(exitMenuItem);

        // Help
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        
        this.setJMenuBar(menuBar);


        // status bar
        JPanel statusBarPanel = new JPanel();
        GridBagLayout statsuBarLayout = new GridBagLayout();
        statsuBarLayout.columnWeights = new double[] { 0.05, 0.45, 0.45,0.05 };
        statsuBarLayout.columnWidths = new int[] { 7, 7, 7, 7 };
        statusBarPanel.setLayout(statsuBarLayout);
        statusBarPanel.setVisible(true);
        statusBarPanel.setFocusable(false);
        this.add(statusBarPanel, BorderLayout.SOUTH);
        
        this.pack();
        this.setVisible(true);
        
    }
    
     public static void main(String[] args){            
        DotAndBoxes game = new DotAndBoxes();  
        
     }
}
