package dotandboxes;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
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
            StartGame(evt);
        });

        labelGameboardSize.setLabelFor(spinnerGameboardSize);
        labelGameboardSize.setText("Spielfeldgrösse");
        
        spinnerGameboardSize.setName("spinnerGameboardSize");

        labelGameMode.setLabelFor(radiobuttonLocal);
        labelGameMode.setText("Spielmodus");

        
        radiobuttonLocal.setText("Lokal");
        radiobuttonNetwork.setText("Netzwerk");
        
        labelIpEnemy = new JLabel();
        labelIpEnemy.setText("IP-Adresse des Gegners");
        
        textFieldIpEnemy = new JTextField();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCreateGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldPlayerName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSpielerName)
                            .addComponent(labelGameboardSize)
                            .addComponent(spinnerGameboardSize, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGameMode)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radiobuttonLocal)
                                .addGap(18, 18, 18)
                                .addComponent(radiobuttonNetwork)))
                        .addGap(0, 221, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSpielerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGameboardSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerGameboardSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGameMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobuttonLocal)
                    .addComponent(radiobuttonNetwork))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCreateGame)
                .addContainerGap())
        );

        textFieldPlayerName.getAccessibleContext().setAccessibleName("textFieldPlayerName");

        pack();
    }
    
    public String getPlayerName(){
        return textFieldPlayerName.getText();
    }
    
    public int getGameboardSize(){
        return (int)spinnerGameboardSize.getValue();
    }    
    
    public String getGamemode(){
        if(radiobuttonLocal.isSelected()){
            return Game.COMPUTER;
        }
        return Game.SERVER;
    }    
    
    public void StartGame(java.awt.event.ActionEvent ev){
        setVisible(false);      
        dispose();
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
