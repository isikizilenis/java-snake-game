package Actions;

import Game.Snake;
import java.lang.System.Logger;
import java.util.ResourceBundle;

public class Collision {

    public static System.Logger logger = new Logger() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isLoggable(Level level) {
            return false;
        }

        @Override
        public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {

        }

        @Override
        public void log(Level level, ResourceBundle bundle, String format, Object... params) {

        }
    };

    public static int pickupCounter = 0;

    public static int getPickupCounter() {
        return pickupCounter;
    }
    public static void setPickupCounter(int pickupCounter) {
        Collision.pickupCounter = pickupCounter;
        logger.log(Logger.Level.INFO, "Set pickup counter to: "+pickupCounter);

    }

    public static boolean collideSelf() {
        for (int i = 0; i < Snake.tails.size(); i++) {
            if (Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY() && !Snake.tails.get(i).isWait()) {
                logger.log(Logger.Level.INFO, "Snake collided with itself");

                return true;
            }
        }
        return false;
    }

    public static boolean collideWall(){
       boolean collision;
       if(Snake.head.getX()<0 || Snake.head.getX() >15 || Snake.head.getY()<0 || Snake.head.getY() >15){
           collision = true;
           logger.log(Logger.Level.INFO, "Snake collided with wall");
       }
       else{
           collision = false;
       }
       return collision;
    }

    public static void collidePickUp(){
        if(Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()){
            Snake.pickup.reset();
            Snake.addTail();
            setPickupCounter(Collision.pickupCounter += 1);
            logger.log(Logger.Level.INFO, "Score: "+pickupCounter);
        }
    }
}
