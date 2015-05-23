/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import dotandboxes.Gui.BoxPicture;
import dotandboxes.Models.Box;
import dotandboxes.Models.BoxListener;
import dotandboxes.Models.Player;
import dotandboxes.Models.Line;
import dotandboxes.Models.ComputerPlayer;
import dotandboxes.Models.GameListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caro
 */
public class Game implements PictureListener {
    private static ArrayList<GameListener> listeners = new ArrayList<>();
    private List<List<Box>> list;
    private static Player player;
    private static Player enemy;
    private static Player currentPlayer;
    
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
        LinePicture.addListener(this);
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
    
    
    public Player getPlayer() {
        return player;
    }
    
    public Player getEnemy(){
        return enemy;
    }
    
    public static boolean isPlayersTurn() {
        return (currentPlayer == player);
    }
    
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public static void othersTurn() {
        if (currentPlayer == player) {
            currentPlayer = enemy;
        }
        else {
            currentPlayer = player;
        } 
    }
    
    
    private Boolean newFullBox() {
        for(List<Box> boxes: list) {
            for(Box box: boxes) {
                if(box.isNewFull()) {
                return true;
                }
            }
        }
        return false;
    }
    
    
    public static void addListener(GameListener toAdd) {
        listeners.add(toAdd);
    }
    
    
    @Override
    public void pictureEvent() {
        if(!newFullBox()) {
            othersTurn();
        }
        else {
            player.increaseScore();
        }
        for (GameListener hl : listeners)
        hl.gameEvent();
    }
}
