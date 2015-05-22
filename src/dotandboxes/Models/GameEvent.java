/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Models;

/**
 *
 * @author Caro
 */
public class GameEvent {
    
    Player currentPlayer;
    Boolean boxFilled;
    
    
    public GameEvent(Player currentPlayer, Boolean boxFilled) {
        this. currentPlayer = currentPlayer;
        this.boxFilled = boxFilled;
    }
    
    
    public boolean isNowBoxFull() {
        return boxFilled;
    }
    
}
