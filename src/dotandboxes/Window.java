/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author lmal
 */
public class Window extends javax.swing.JFrame implements ActionListener {
    
    
    public Window(){
        
        GUI();
        
    }
    
    	private void GUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.setTitle("Dots and Boxes");
		this.setSize(450, 400);
		BorderLayout thisLayout = new BorderLayout();
		this.getContentPane().setLayout(thisLayout);
                
		{
			JMenuBar menuBar = new JMenuBar();
			this.setJMenuBar(menuBar);

			
			JMenu gameMenu = new JMenu("Game");
			menuBar.add(gameMenu);


			JMenuItem newGameMenuItem = new JMenuItem("New Game");
			gameMenu.add(newGameMenuItem);

			// Exit
			JMenuItem exitMenuItem = new JMenuItem("Exit");
			exitMenuItem.addActionListener(this);
			gameMenu.add(exitMenuItem);

			// Help
			JMenu helpMenu = new JMenu("Help");
			menuBar.add(helpMenu);
		}

		{// status bar
			JPanel statusBarPanel = new JPanel();
			GridBagLayout statsuBarLayout = new GridBagLayout();
			statsuBarLayout.columnWeights = new double[] { 0.05, 0.45, 0.45,
					0.05 };
			statsuBarLayout.columnWidths = new int[] { 7, 7, 7, 7 };
			statusBarPanel.setLayout(statsuBarLayout);
			this.getContentPane().add(statusBarPanel, BorderLayout.SOUTH);
			statusBarPanel.setVisible(true);
			statusBarPanel.setFocusable(false);

		}
	}

	/**
	 * Handles menu events. Implements ActionListener.actionPerformed().
	 * 
	 * @param e object with information about the event
	 */
	public void actionPerformed(ActionEvent e) {
		// System.out.println("actionPerformed: " + e.getActionCommand());

		if (e.getActionCommand().equals("Exit")) {

			this.dispose();
                 
		}
	}

}
