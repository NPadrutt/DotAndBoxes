package dotandboxes.Models;

import dotandboxes.Enemy;
import dotandboxes.Game;

public class NetworkPlayer extends Enemy implements GameListener {
    
    public NetworkPlayer(){
        setName("Computer Player");
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
