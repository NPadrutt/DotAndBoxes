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

/**
 *
 * @author Nino
 */
public class CreateGameDialog extends javax.swing.JDialog {
    
    private final JButton buttonCreateGame;
    private final JLabel labelSpielerName;
    private final JLabel labelGameboardSize;
    private final JLabel labelGameMode;
    private final JRadioButton radiobuttonLocal;
    private final JRadioButton radiobuttonNetwork;
    private final ButtonGroup buttonGroup;
    private final JSpinner spinnerGameboardSize;
    private final JTextField textFieldPlayerName;

    /**
     * Creates new form CreateGameDialog
     */
    public CreateGameDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
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
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        labelSpielerName.setLabelFor(textFieldPlayerName);
        labelSpielerName.setText("Spielername");

        textFieldPlayerName.setName("textFieldPlayerName");

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateGameDialog dialog = new CreateGameDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
