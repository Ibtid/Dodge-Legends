package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObjects{

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        velocityX = 5;
        velocityY = 5;
    }

    @Override
    public void tick() {
        x+=velocityX;
        y+=velocityY;
        
        if(y<10 || y>=DodgeLegends.height-60) velocityY *= -1;
        if(x<0 || x>=DodgeLegends.width-40) velocityX *= -1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(x, y, 30, 30);
        
    }
    
    @Override
    public Rectangle getbounds() {
 
        return new Rectangle (x, y, 16, 16);
    }

}
