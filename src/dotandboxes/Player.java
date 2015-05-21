package dotandboxes;

/**
 *
 * @author Nino
 */
public class Player {    
    private String name;
    private int score;
    
    public Player(){
        score = 0;
    }
    
    public Player(int score) {
        this.score = score;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getrName(){
        return this.name;
    }
    
    public int getScore(){
        return score;
    }
    
    public void increaseScore(){
        score ++;
    }    
}
