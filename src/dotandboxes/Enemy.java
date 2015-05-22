/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import dotandboxes.Models.EnemyListener;
import dotandboxes.Models.Player;
import java.util.ArrayList;

/**
 *
 * @author Caro
 */
public abstract class Enemy extends Player {
    
    public static ArrayList<EnemyListener> listeners;
    
    public Enemy() {
        super();
    }
    
    public Enemy(int score) {
        super(score);
    }
    
    public static void addListener(EnemyListener toAdd) {
        listeners.add(toAdd);
    }
    
    public void enemyEvent() {
        for (EnemyListener hl : listeners)
            hl.enemyEvent();
    }
    
    public abstract void play();
    
}
