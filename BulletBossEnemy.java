package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BulletBossEnemy extends GameObjects{

    private Handler handler;
    Random r = new Random();
    
    public BulletBossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velocityX = r.nextInt((5+1) - -5) + -5;
        velocityY = r.nextInt((4+1) - -4) + -4;
    }

    @Override
    public void tick() {
        x+=velocityX;
        y+=velocityY;
        
        if(y<10)velocityY *=-1;
        if(y>=DodgeLegends.height-60) handler.removeObject(this);
        if(x<0 || x>=DodgeLegends.width-40) velocityX *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, new Color(229,204,255), 0.2f, 16, 16, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(229,204,255));
        graphics.fillOval(x, y, 16, 16);
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 16, 16);
    }

}
