package dotandboxes.Gui;

import dotandboxes.Gamemode;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
public class CreateGameDialog extends JDialog {
    
    private final JButton buttonCreateGame;
    private final JLabel labelSpielerName;
    private final JLabel labelGameboardSize;
    private final JSpinner spinnerGameboardSizeVertical;
    private final JSpinner spinnerGameboardSizeHorizontal;
    private final JTextField textFieldPlayerName;
    
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
        
        SpinnerModel modelVertical = new SpinnerNumberModel(3,3,30, 1);
        spinnerGameboardSizeHorizontal = new JSpinner(modelVertical);
        
        SpinnerModel modelHorizontal = new SpinnerNumberModel(3,3,30, 1);
        spinnerGameboardSizeVertical = new JSpinner(modelHorizontal);
        
        labelSpielerName.setText("Spielername");
        labelGameboardSize.setText("Spielfeldgrösse (Hor. / Ver.)");

        buttonCreateGame.setText("Los Gehts!");
        buttonCreateGame.setName("buttonStart");
        buttonCreateGame.addActionListener((ActionEvent evt) -> {
            setVisible(false);    
            dispose();
        });

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCreateGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldPlayerName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelSpielerName)
                            .addComponent(labelGameboardSize)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spinnerGameboardSizeVertical)
                                .addGap(7)
                                .addComponent(spinnerGameboardSizeHorizontal)))
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
                .addGroup(layout.createParallelGroup()
                    .addComponent(spinnerGameboardSizeVertical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerGameboardSizeHorizontal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCreateGame)
                .addContainerGap())
        );
        pack();
    }
    
    public String getPlayerName(){    
        return !textFieldPlayerName.getText().equals("")
                ? textFieldPlayerName.getText()
                : "Player";
    }
    
    public int getGameboardSizeVertical(){
        return (int)spinnerGameboardSizeVertical.getValue();
    } 
    
    public int getGameboardSizeHorizontal(){
        return (int)spinnerGameboardSizeHorizontal.getValue();
    } 
        
    public Gamemode getGamemode(){
        return Gamemode.Local;
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
