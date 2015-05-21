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
    
    public static final String SERVER = "server";
    public static final String COMPUTER = "computer";
    private List<List<Box>> list;
    private Player player;
    private Player enemy;
    private Player currentPlayer;

    
    
    /**
     * Erstellt ein neues Spiel der Grösse x mal y. Modus definiert ob gegen den
     * Computer oder ein Mensch im Netzwerk gespielt wird.
     * @param x
     * @param y
     * @param Modus 
     */
    public Game(int x, int y, String name, String modus) {
        
        //Spielfeld erstellen
        list = new ArrayList<>();
        ArrayList<Box> boxes = new ArrayList<Box>();
        //Erste Box
        Box box = new Box();
        boxes.add(box);
        //Erste Spalte
        for (int row = 1; row <= y; row++) {
            box = new Box(box.getUpperLine(), Line.POSITION_UPPER);
            boxes.add(box);
        }
        list.add(boxes);
        
        //Erste Zeile
        for (int col = 2; col <= x; col++) {
            box = new Box(list.get(col-2).get(0).getLeftLine(), Line.POSITION_LEFT);
            boxes = new ArrayList<>();
            boxes.add(box);
            list.add(boxes);
        }
        
        //Rest
        for (int col = 2; col <= x; col++) {
            for (int row = 2; row <= y; row++) {
                Line left = list.get(col-2).get(row-1).getLeftLine();
                Line up = list.get(col-1).get(row-2).getUpperLine();
                box = new Box(up, left);
                list.get(col-1).add(box);
            }
        }
        
        //Create Players
        player = new Player();
        player.setName(name);
        
        if (modus.equals(COMPUTER))  {
            enemy = new ComputerPlayer();
        }
        else if (modus.equals(SERVER)) {
            
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
    
    
    public boolean isPlayersTurn() {
        return (currentPlayer == player);
    }
}
