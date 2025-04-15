package Game;

import GUI.Gui;

import java.awt.*;
import java.util.ArrayList;

import static Actions.Collision.logger;

public class Snake {

    public static boolean waitToMove = false;                     // Verhindert das "Rückwärts gehen" der Schlange,
                                                                  // wenn man zb zu schnelle Tastenkompinationen macht
    public static Head head = new Head(7, 7);               // Schlange hat jetzt nen Kopf
    public static ArrayList<Tail> tails = new ArrayList<>();      // Schlange hat jetzt nen fetten Schwanz 3==D

    public static PickUp pickup = new PickUp();

    /*
    Die folgende Methode fügt der dynamischen Arrayliste bei Kollision mit einem PickUp ein neues Tail hinzu.
    Wenn die tails Liste noch 0 Elemente lang ist, wird an die Stelle des Kopfes ein neues Tail hinzugefügt.
    Sonst wird an die letzte Stelle - also tails.size()-1 ein neues tails hinzugefügt.
     */
    public static void addTail(){
        if (tails.isEmpty()) {
            tails.add(new Tail(head.getX(), head.getY()));
        }
        else {
            tails.add(new Tail(tails.get(tails.size()-1).x, tails.get(tails.size()-1).y));
        }
        logger.log(System.Logger.Level.INFO, "Added new Tail-Fragment at x:"+tails.get(tails.size()-1).x+", y:"+tails.get(tails.size()-1).y);
    }

    public static void move(){
        //Move Tails
        if(tails.size() > 1){
            for(int i = tails.size()-1; i>=1; i--){
                if(tails.get(i).isWait()){
                    tails.get(i).setWait(false);
                } else {
                    tails.get(i).setX(tails.get(i-1).getX());
                    tails.get(i).setY(tails.get(i-1).getY());
                }
            }
        }

        //Move first tail to head
        if(!tails.isEmpty()){
            if(tails.get(0).isWait()){
                tails.get(0).setWait(false);
            } else {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        //Move Head
        switch (head.getDirection()) {
            case RIGHT -> head.setX(head.getX() + 1);
            case UP -> head.setY(head.getY() - 1);
            case LEFT -> head.setX(head.getX() - 1);
            case DOWN -> head.setY(head.getY() + 1);
        }
    }

    //position to coordinate
    public static Point ptc(int x, int y){
        Point p = new Point(0, 0);
        p.x = x*32 + Gui.xoff;
        p.y = y*32 + Gui.yoff;


        return p;
    }
}