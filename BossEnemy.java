package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObjects{

    private Handler handler;
    Random r = new Random();
    
    private int timer = 30;
    private int timer2 = 50;
    
    public BossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velocityX = 0;
        velocityY = 6;
    }

    @Override
    public void tick() {
        x+=velocityX;
        y+=velocityY;
        
        if(timer <=0)
            velocityY = 0;
        else
            timer--;
        
        if(timer<=0) timer2--;
        if(timer2 <= 0){
            if(velocityX == 0)
                velocityX = 7;
            int spawn = r.nextInt(20);
            if(spawn == 0) 
                handler.addObject(new BulletBossEnemy( x, y+40, ID.BulletBossEnemy, handler));
        }
        
       //if(y<10 || y>=DodgeLegends.height-80) velocityY *= -1;
        if(x<0 || x>=DodgeLegends.width-60) velocityX *= -1;
        
        //handler.addObject(new Trail(x, y, ID.Trail, new Color(204,0,0), 0.02f, 60, 60, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(178,102,255));
        graphics.fillOval(x, y, 60, 60);
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 60, 60);
    }

    
}
