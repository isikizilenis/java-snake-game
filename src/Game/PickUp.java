package Game;

import java.util.concurrent.ThreadLocalRandom;

import static Actions.Collision.logger;

public class PickUp {
    int x, y;

    public PickUp(){
        this.x = ThreadLocalRandom.current().nextInt(0, 15);
        this.y = ThreadLocalRandom.current().nextInt(0, 15);
    }
    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0, 15);
        this.y = ThreadLocalRandom.current().nextInt(0, 15);
        logger.log(System.Logger.Level.INFO, "New Pickup on x:"+getX()+", y:"+getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        logger.log(System.Logger.Level.INFO, "Set Pickup X: "+x);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        logger.log(System.Logger.Level.INFO, "Set Pickup Y: "+y);
        this.y = y;
    }
}
