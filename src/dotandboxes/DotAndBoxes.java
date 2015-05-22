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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author lmal
 */
public class DotAndBoxes extends javax.swing.JFrame implements ActionListener {    
    
    static CreateGameDialog dialog;
    
    private void GUI() {        
        dialog = new CreateGameDialog(this, true);
        dialog.setVisible(true);
        createGame ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("actionPerformed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Exit")) {
                this.dispose();
        }
    }
    
    public  void createGame (){        
        JFrame frame;
        frame = new JFrame();
        frame.setTitle("Dots and Boxes");
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout thisLayout = new BorderLayout();
        frame.getContentPane().setLayout(thisLayout); 

        Game game = new Game(dialog.getGameboardSize(),dialog.getGameboardSize(),dialog.getPlayerName(),dialog.getGamemode());
        Gameboard gameboard = new Gameboard(game.getList());

        frame.add(gameboard);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);


        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);


        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        gameMenu.add(newGameMenuItem);

        // Exit
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener((ActionListener) frame);
        gameMenu.add(exitMenuItem);

        // Help
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);


        // status bar
        JPanel statusBarPanel = new JPanel();
        GridBagLayout statsuBarLayout = new GridBagLayout();
        statsuBarLayout.columnWeights = new double[] { 0.05, 0.45, 0.45,0.05 };
        statsuBarLayout.columnWidths = new int[] { 7, 7, 7, 7 };
        statusBarPanel.setLayout(statsuBarLayout);
        frame.getContentPane().add(statusBarPanel, BorderLayout.SOUTH);
        statusBarPanel.setVisible(true);
        statusBarPanel.setFocusable(false);

    }
    
     public static void main(String[] args){            
        DotAndBoxes game = new DotAndBoxes();
        game.GUI();    
        
     }
}
