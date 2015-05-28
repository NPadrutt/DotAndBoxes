package dotandboxes.Models;

import dotandboxes.Game;
import java.util.List;
import java.util.Random;


public class ComputerPlayer extends Enemy implements GameListener {
    
    private static List<List<Box>> list;
    private static Random random = new Random();
    
    public ComputerPlayer(List<List<Box>> list) {
        super();
        super.setName("Computer");
        ComputerPlayer.list = list;
        Game.addListener(this);
    }
    
    public ComputerPlayer(List<List<Box>> list, int score) {
        super(score);
        super.setName("Computer");
        ComputerPlayer.list = list;
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
                    box.isNowFull();
                    super.increaseScore();
                    enemyEvent();
                }
            }
        }
        Boolean marked = false;
        Boolean allFull = false;
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
                else if (!list.get(x).get(y).getRightLine().getIsMarked()){
                    list.get(x).get(y).getLeftLine().setIsMarked(true);
                    marked = !marked;
                }
            }
                        
            for(List<Box> boxList : list){
                for(Box box : boxList ) {
                    allFull = box.isBoxFull();
                }
            }
        } while (!marked && !allFull);
        enemyEvent();
        Game.othersTurn();
    }
}
