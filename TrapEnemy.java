package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class TrapEnemy extends GameObjects{

    private Handler handler;
    private GameObjects player;
    
    public TrapEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId()==ID.Player)
                player = handler.object.get(i);
        }
        
        velocityY = 1;   
    }

    @Override
    public void tick() {
        
        velocityX = (player.x-x)/17;
        
        x+=velocityX;
        y+=velocityY;
        
        if(y<10 || y>=DodgeLegends.height-60) velocityY *= -1;
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 0.02f, 16, 16, handler ));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillOval(x, y, 16, 16);
        
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 16, 16);
    }

}
