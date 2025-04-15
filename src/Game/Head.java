package Game;

import static Actions.Collision.logger;

public class Head {
    Direction direction = Direction.UP;      //Anfangsrichtung des Heads
    int x, y;

    public Head(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        logger.log(System.Logger.Level.INFO, "Direction changed to "+direction);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}