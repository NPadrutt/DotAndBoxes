/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

/**
 *
 * @author Caro
 */
public class ComputerPlayer extends Player {
    
    public ComputerPlayer() {
        super();
        super.setName("Computer");
    }
    
    public ComputerPlayer(int score) {
        super(score);
        super.setName("Computer");
    }
    
    public void play() {
        
    }
}
