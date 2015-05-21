/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.awt.Frame;

/**
 *
 * @author Nino
 */
public class CreateGameDialog extends javax.swing.JDialog {
    
    private final javax.swing.JButton buttonCreateGame;
    private final javax.swing.JLabel labelSpielerName;
    private final javax.swing.JLabel labelGameboardSize;
    private final javax.swing.JLabel jLabel3;
    private final javax.swing.JRadioButton radiobuttonLocal;
    private final javax.swing.JRadioButton radiobuttonNetwork;
    private final javax.swing.JSpinner spinnerGameboardSize;
    private final javax.swing.JTextField textFieldPlayerName;

    /**
     * Creates new form CreateGameDialog
     */
    public CreateGameDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        labelSpielerName = new javax.swing.JLabel();
        textFieldPlayerName = new javax.swing.JTextField();
        buttonCreateGame = new javax.swing.JButton();
        labelGameboardSize = new javax.swing.JLabel();
        spinnerGameboardSize = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        radiobuttonLocal = new javax.swing.JRadioButton();
        radiobuttonNetwork = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        labelSpielerName.setLabelFor(textFieldPlayerName);
        labelSpielerName.setText("Spielername");

        textFieldPlayerName.setName("textFieldPlayerName"); // NOI18N

        buttonCreateGame.setText("Los Gehts!");
        buttonCreateGame.setName("buttonStart"); // NOI18N
        buttonCreateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGame(evt);
            }
        });

        labelGameboardSize.setLabelFor(spinnerGameboardSize);
        labelGameboardSize.setText("Spielfeldgrösse");

        spinnerGameboardSize.setName("spinnerGameboardSize"); // NOI18N

        jLabel3.setLabelFor(radiobuttonLocal);
        jLabel3.setText("Spielmodus");

        radiobuttonLocal.setText("Lokal");
        radiobuttonLocal.setActionCommand("radioButtonLocal");
        radiobuttonLocal.setName("radioButtonLocal"); // NOI18N

        radiobuttonNetwork.setText("Netzwerk");
        radiobuttonNetwork.setName("radioButtonNetwork"); // NOI18N

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
                            .addComponent(jLabel3)
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
                .addComponent(jLabel3)
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
    
    
    public Gamemode getGamemode(){
        if(radiobuttonLocal.isSelected()){
            return Gamemode.Local;
        }
        return Gamemode.Network;
    }    
    
    public void StartGame(java.awt.event.ActionEvent ev){
        setVisible(false);
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
