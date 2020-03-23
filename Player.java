package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class Player extends GameObjects{
    
    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
        
        x = DodgeLegends.clamp(x, 0, DodgeLegends.width-40);
        y = DodgeLegends.clamp(y, 0, DodgeLegends.height-75);
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 0.05f, 32, 32, handler ));
        
        collision();
        
    }
    
    private void collision(){
        
        for(int i = 0; i < handler.object.size(); i++){
            
            GameObjects tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy){
                
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH-=2;
                    tempObject.velocityX *= -1;
                    tempObject.velocityY *= -1;
                }
                
            }
        }
        
    }
    

    @Override
    public void render(Graphics graphics) {
        
        graphics.setColor(Color.yellow);
        graphics.fillOval(x, y, 32, 32);
    }
    
}
