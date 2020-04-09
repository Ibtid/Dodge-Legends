package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BulletBossEnemy extends GameObjects{

    private Handler handler;
    Random r = new Random();
    
    private GameObjects boss;
    
    public BulletBossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId()==ID.BossEnemy)
                boss = handler.object.get(i);
        }
        
        //velocityX = r.nextInt((5+1) - -5) + -5;
        velocityX = r.nextInt((4+1) - -4) + -4;
        //velocityY = 1;
    }

    @Override
    public void tick() {
        velocityY = (boss.x-x)/100;

        
        x+=velocityX;
        y+=velocityY;
        
       // if(y<10)velocityY *=-1;
        if(y<10 || y>=DodgeLegends.height-60) handler.removeObject(this);
        if(x<0 || x>=DodgeLegends.width-40) velocityX *= -1;
        
        //handler.addObject(new Trail(x, y, ID.Trail, new Color(180,154,245), 0.2f, 16, 16, handler ));
        handler.addObject(new Trail(x, y, ID.Trail, new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)), 0.2f, 16, 16, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        //graphics.setColor(new Color(180,154,245));
        graphics.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        graphics.fillOval(x, y, 16, 16);
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 16, 16);
    }

}

