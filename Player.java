package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class Player extends GameObjects{
    
    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
        
    }
    
    @Override
    public Rectangle getbounds(){
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
        
        x = DodgeLegends.clamp(x, 0, DodgeLegends.width-40);
        y = DodgeLegends.clamp(y, 0, DodgeLegends.height-80);
        
        /*if(y>=DodgeLegends.height-80) y = DodgeLegends.height-80 ;
        if(x>=DodgeLegends.width-40) x = DodgeLegends.width-40; 
        if(y<7) y = 7;
        if(x<0) x = 0;*/
    }
    

    @Override
    public void render(Graphics graphics) {
        
        graphics.setColor(Color.yellow);
        graphics.fillOval(x, y, 32, 32);
        
    }
    
}
