package dotandboxes.Gui;

import dotandboxes.Gamemode;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

/**
 *
 * @author Nino
 */
public class CreateGameDialog extends javax.swing.JDialog {
    
    private final JButton buttonCreateGame;
    private final JLabel labelSpielerName;
    private final JLabel labelGameboardSize;
    private final JLabel labelGameMode;
    private final JLabel labelIpEnemy;
    private final JRadioButton radiobuttonLocal;
    private final JRadioButton radiobuttonNetwork;
    private final ButtonGroup buttonGroup;
    private final JSpinner spinnerGameboardSize;
    private final JTextField textFieldPlayerName;
    private final JTextField textFieldIpEnemy;
    
    public CreateGameDialog(Frame parent) {
        super(parent, true);
        initComponents();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        
        labelSpielerName = new JLabel();
        textFieldPlayerName = new JTextField();
        buttonCreateGame = new JButton();
        labelGameboardSize = new JLabel();
        labelIpEnemy = new JLabel();
        textFieldIpEnemy = new JTextField();
        
        SpinnerModel model = new SpinnerNumberModel(3,3,30, 1);
        spinnerGameboardSize = new JSpinner(model);
        labelGameMode = new JLabel();
        
        radiobuttonLocal = new JRadioButton();
        radiobuttonNetwork = new JRadioButton();
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radiobuttonLocal);
        buttonGroup.add(radiobuttonNetwork);
        labelSpielerName.setText("Spielername");

        buttonCreateGame.setText("Los Gehts!");
        buttonCreateGame.setName("buttonStart");
        buttonCreateGame.addActionListener((ActionEvent evt) -> {
            setVisible(false);      
            dispose();
        });

        labelGameboardSize.setLabelFor(spinnerGameboardSize);
        labelGameboardSize.setText("Spielfeldgrösse");
        
        spinnerGameboardSize.setName("spinnerGameboardSize");

        labelGameMode.setLabelFor(radiobuttonLocal);
        labelGameMode.setText("Spielmodus");
        
        radiobuttonLocal.setText("Lokal");
        radiobuttonLocal.setSelected(true);
        radiobuttonNetwork.setText("Netzwerk");
        
        labelIpEnemy.setText("IP-Adresse des Gegners");
        labelIpEnemy.setVisible(false);
        textFieldIpEnemy.setVisible(false);
        
        radiobuttonLocal.addActionListener((ActionEvent evt) -> {
            labelIpEnemy.setVisible(false);
            textFieldIpEnemy.setVisible(false);
        });       
       
        radiobuttonNetwork.addActionListener((ActionEvent evt) -> {
            labelIpEnemy.setVisible(true);
            textFieldIpEnemy.setVisible(true);
        });

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCreateGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldIpEnemy)
                    .addComponent(textFieldPlayerName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelSpielerName)
                            .addComponent(labelGameboardSize)
                            .addComponent(labelIpEnemy)
                            .addComponent(spinnerGameboardSize, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGameMode)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radiobuttonLocal)
                                .addGap(18, 18, 18)
                                .addComponent(radiobuttonNetwork)))
                        .addGap(18, 221, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSpielerName)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(textFieldPlayerName, PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGameboardSize)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerGameboardSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGameMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobuttonLocal)
                    .addComponent(radiobuttonNetwork))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIpEnemy)
                .addComponent(textFieldIpEnemy, PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCreateGame)
                .addContainerGap())
        );
        pack();
    }
    
    public String getPlayerName(){    
        return textFieldPlayerName.getText() != null 
                ? textFieldPlayerName.getText()
                : "Player";
    }
    
    public int getGameboardSize(){
        return (int)spinnerGameboardSize.getValue();
    } 
    
    public String getIpAdress(){
        return textFieldIpEnemy.getText();
    }
    
    public Gamemode getGamemode(){
        if(radiobuttonLocal.isSelected()){
            return Gamemode.Local;
        }
        return Gamemode.Network;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
