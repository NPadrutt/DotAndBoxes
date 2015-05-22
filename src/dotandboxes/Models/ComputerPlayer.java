/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes.Models;

import dotandboxes.Enemy;
import dotandboxes.Game;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Caro
 */
public class ComputerPlayer extends Enemy implements GameListener {
    
    List<List<Box>> list;
    
    public ComputerPlayer(List<List<Box>> list) {
        super();
        super.setName("Computer");
        this.list = list;
        Game.addListener(this);
    }
    
    public ComputerPlayer(List<List<Box>> list, int score) {
        super(score);
        super.setName("Computer");
        this.list = list;
        Game.addListener(this);
    }
    
    @Override
    public void gameEvent() {
        if(Game.getCurrentPlayer() == this) {
            play();
        }
    }
    
    @Override
    public void play() {
        for(List<Box> boxes: list) {
            for(Box box: boxes) {
                if (box.isNearlyFull()) {
                    box.getLastLine().setIsMarked(true);
                    super.increaseScore();
                    enemyEvent();
                }
            }
        }
        Random random = new Random();
        Boolean marked = false;
        do {
            int x = random.nextInt(list.size());
            int y = random.nextInt(list.get(0).size());
            if (!list.get(x).get(y).isBoxFull()) {
                if(!list.get(x).get(y).getBottomLine().getIsMarked()) {
                    list.get(x).get(y).getBottomLine().setIsMarked(true);
                    marked = !marked;
                }
                else if(!list.get(x).get(y).getRightLine().getIsMarked()) {
                    list.get(x).get(y).getRightLine().setIsMarked(true);
                    marked = !marked;
                }
                else if(!list.get(x).get(y).getUpperLine().getIsMarked()) {
                    list.get(x).get(y).getUpperLine().setIsMarked(true);
                    marked = !marked;
                }
                else {
                    list.get(x).get(y).getLeftLine().setIsMarked(true);
                    marked = !marked;
                }
            }
        } while (!marked);
        enemyEvent();
        Game.othersTurn();
    }
}
