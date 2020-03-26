
package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class FastEnemy extends GameObjects{

    private Handler handler;
    
    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velocityX = 2;
        velocityY = 7;
    }

    
   
    @Override
    public void tick() {
        x+=velocityX;
        y+=velocityY;
        
        if(y<10 || y>=DodgeLegends.height-60) velocityY *= -1;
        if(x<0 || x>=DodgeLegends.width-40) velocityX *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 0.02f, 12, 12, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillOval(x, y, 12, 12);
        
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 12, 12);
    }

}


