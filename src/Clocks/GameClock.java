package Clocks;

import Actions.Collision;
import GUI.GameOverGUI;
import Game.Snake;

import static Actions.Collision.logger;

public class GameClock extends Thread{

    public boolean isRunning;
    public int sleepvar;
    public void setRunning(boolean running) {
        isRunning = running;
    }
    public int getSleepvar() {
        return sleepvar;
    }
    public void setSleepvar(int sleepvar) {
        this.sleepvar = sleepvar;
    }

    public void run(){
        while(isRunning){
            try {
                sleep(getSleepvar());
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if(Collision.collideSelf()){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    GameOver();
                    Collision.setPickupCounter(0);
                    //Score
                }
                if(Collision.collideWall()){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    GameOver();
                    Collision.setPickupCounter(0);
                    //Score
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void GameOver(){
        setRunning(false);
        logger.log(System.Logger.Level.INFO, "Game over");
        logger.log(System.Logger.Level.INFO, "Score: "+Collision.getPickupCounter());
        GameOverGUI gg = new GameOverGUI();
        gg.setVisible(true);
    }
}
