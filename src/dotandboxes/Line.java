package dotandboxes;

/**
 *
 * @author Nino
 */
public class Line {
    
    public static final String POSITION_LEFT = "left";
    public static final String POSITION_UPPER = "upper";

    private Boolean isMarked;
    
    public Line() {
        isMarked = false;
    }
    
    public void setIsMarked(Boolean isMarked){
        this.isMarked = isMarked;
    }
    
    public Boolean getIsMarked(){
        return isMarked;
    }
}
