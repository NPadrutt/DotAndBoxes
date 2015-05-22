/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caro
 */
public class Game {
    private List<List<Box>> list;
    public static  Player player;
    public static  Player enemy;
    public static  Player currentPlayer;
    
    public Game(int x, int y, String name, Gamemode modus) {
        
        //Spielfeld erstellen
        list = new ArrayList<>();
        ArrayList<Box> boxes = new ArrayList<>();
        
        //Erste Box
        Box box = new Box();
        boxes.add(box);
        
        //Erste Spalte
        for (int row = 2; row <= y; row++) {
            box = new Box(box.getBottomLine(), Line.POSITION_UPPER);
            boxes.add(box);
        }
        list.add(boxes);
        
        //Erste Zeile
        for (int col = 2; col <= x; col++) {
            box = new Box(list.get(col-2).get(0).getRightLine(), Line.POSITION_LEFT);
            boxes = new ArrayList<>();
            boxes.add(box);
            list.add(boxes);
        }
        
        //Rest
        for (int col = 2; col <= x; col++) {
            for (int row = 2; row <= y; row++) {
                Line left = list.get(col-2).get(row-1).getRightLine();
                Line up = list.get(col-1).get(row-2).getBottomLine();
                box = new Box(up, left);
                list.get(col-1).add(box);
            }
        }
        
        //Create Players
        player = new Player();
        player.setName(name);
        currentPlayer = player;
        
        if (modus.equals(Gamemode.Local))  {
            enemy = new ComputerPlayer(list);
        }
        else if (modus.equals(Gamemode.Network)) {
            
        }        
    }
    
    /**
     * Lädt ein Spiel von Textfile.
     * @param filename
     */
    public Game (String filename) {
        
    }
    
    public List getList() {
        return list;
    }    
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }    
    
    public String getPlayername() {
        return player.getName();
    }
    
    public String getEnemyname(){
        return enemy.getName();
    }
    
    public static boolean isPlayersTurn() {
        return (currentPlayer == player);
    }
}
