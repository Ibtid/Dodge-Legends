package dodge.legends;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObjects {
    
    protected int x, y;
    protected ID id;
    protected int velocityX,velocityY;
    
    public GameObjects(int x, int y, ID id){
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    public abstract void render(Graphics graphics);
    public abstract Rectangle getBounds();

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

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
    
}
