package dotandboxes;

public class Box {
    
    private Line leftLine;
    private Line upperLine;
    private Line rightLine;
    private Line bottomLine;
    
    public Box(){ 
        leftLine = new Line();
        upperLine = new Line();
        rightLine = new Line();
        bottomLine = new Line();
    }
    
    public Box(Line line, String Position){
        switch (Position) {
            case Line.POSITION_LEFT:
                leftLine = line;
                break;
            case Line.POSITION_UPPER:
                upperLine = line;
                break;
            default:
                throw new IllegalArgumentException("Only Left and Upper Lines are supporter.");
        }
    }
    
    public Box(Line upperLine, Line leftLine){
        this.upperLine = upperLine;
        this.leftLine = leftLine;
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
}
