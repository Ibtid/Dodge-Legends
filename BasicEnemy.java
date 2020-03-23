package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObjects{

    private Handler handler;
    
    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velocityX = 5;
        velocityY = 5;
    }

    @Override
    public void tick() {
        x+=velocityX;
        y+=velocityY;
        
        if(y<10 || y>=DodgeLegends.height-60) velocityY *= -1;
        if(x<0 || x>=DodgeLegends.width-40) velocityX *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 0.02f, 16, 16, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(x, y, 16, 16);
        
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 16, 16);
    }

}
