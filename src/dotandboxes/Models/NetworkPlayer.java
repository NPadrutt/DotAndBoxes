package dotandboxes.Models;

import dotandboxes.Enemy;
import dotandboxes.Game;

public class NetworkPlayer extends Enemy implements GameListener {
    private String ipAddress;
    
    public NetworkPlayer(String ipAddress){
        this.ipAddress = ipAddress;
        setName("Computer Player");
    }
    
    public void SendTurn(){
        
    } 
    
    public void ReceiveTurn(){
        
    }

    @Override
    public void gameEvent() {
        if(Game.getCurrentPlayer() == this) {
            play();
        }
    }
    
    @Override
    public void play() {
        
    }
}
