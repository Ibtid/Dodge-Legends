package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class MenuParticle extends GameObjects{

    private Handler handler;
    
    Random r = new Random();
    
    private Color color;

    
    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velocityX = r.nextInt((4+1) - -4) + -4;
        velocityY = r.nextInt((4+1) - -4) + -4;
        if(velocityX == 0) velocityX = 3;
        if(velocityY == 0) velocityY =3;
        
        color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
                
    }

    
   
    @Override
    public void tick() {
        x+=velocityX;
        y+=velocityY;
        
        if(y<10 || y>=DodgeLegends.height-60) velocityY *= -1;
        if(x<0 || x>=DodgeLegends.width-40) velocityX *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, color, 0.02f, 16, 16, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x, y, 16, 16);
        
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 16, 16);
    }

}

