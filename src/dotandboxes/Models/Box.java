package dotandboxes.Models;

import dotandboxes.Game;

public class Box {
    
    private Line leftLine;
    private Line upperLine;
    private Line rightLine;
    private Line bottomLine;
    private Boolean marked;
    private Player markedBy;
    
    public Box(){ 
        leftLine = new Line();
        upperLine = new Line();
        rightLine = new Line();
        bottomLine = new Line();
        marked = false;
    }
    
    public Box(Line line, String Position){
        switch (Position) {
            case Line.POSITION_LEFT:
                leftLine = line;
                upperLine = new Line();
                break;
            case Line.POSITION_UPPER:
                upperLine = line;
                leftLine = new Line();
                break;
            default:
                throw new IllegalArgumentException("Only Left and Upper Lines are supporter.");
        }
        this.rightLine = new Line();
        this.bottomLine = new Line();
        marked = false;
    }
    
    public Box(Line upperLine, Line leftLine){
        this.upperLine = upperLine;
        this.leftLine = leftLine;
        this.rightLine = new Line();
        this.bottomLine = new Line();
        marked = false;
    }
    
    public Line getLeftLine(){
        return leftLine;
    }
    
    public Line getUpperLine(){
        return upperLine;
    }
    
    public Line getRightLine(){
        return rightLine;
    }
    
    public Line getBottomLine(){
        return bottomLine;
    }
    
    public Boolean isBoxFull(){
        return leftLine.getIsMarked() 
                && upperLine.getIsMarked()
                && rightLine.getIsMarked() 
                && bottomLine.getIsMarked();
    }
    
    public Boolean isNewFull() {
        if(!marked) {
            if(leftLine.getIsMarked() 
                        && upperLine.getIsMarked()
                        && rightLine.getIsMarked() 
                        && bottomLine.getIsMarked()) {
                marked = true;
                markedBy = Game.getCurrentPlayer();
            }
            return marked;
        }
        return false;
    }
    
    public void isNowFull() {
        marked = true;
    }
    
    @Override
    public String toString(){
        return "";
    }
    
    public boolean isNearlyFull() {
        if((leftLine.getIsMarked()?1:0)+(upperLine.getIsMarked()?1:0)+(rightLine.getIsMarked()?1:0)+(bottomLine.getIsMarked()?1:0) == 3) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Funktioniert nur richtig, wenn isNearlyFull true zurück gibt.
     * @return 
     */
    public Line getLastLine() {
        if(!leftLine.getIsMarked()) {
            return leftLine;
        }
        else if(!upperLine.getIsMarked()) {
            return upperLine;
        }
        else if(!rightLine.getIsMarked()) {
            return rightLine;
        }
        else if(!bottomLine.getIsMarked()) {
            return bottomLine;
        }
        else {
            return null;
        }
    }
    
    public Player getMarkedBy() {
        return markedBy;
    }
}
