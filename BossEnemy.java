package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObjects{
    
    int health = 125;
    int green = 255; ;

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
        
        health = DodgeLegends.clamp(health, 0, 125);
        green = DodgeLegends.clamp(green, 0, 255);
        
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
            
        if(x<0 || x>=DodgeLegends.width-60) {
            velocityX *= -1;
            velocityY = 20;
            if(y<10 || y>=DodgeLegends.height-120){
                velocityY = -300;
            }
        }
                   
        handler.addObject(new Trail(x, y, ID.Trail, new Color(178,102,255), 0.3f, 60, 60, handler ));
        
        collision();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(178,102,255));
        graphics.fillOval(x, y, 60, 60);
        
        drawHUD (graphics);
        
    }
    
    @Override
    public Rectangle getBounds() {
 
        return new Rectangle (x, y, 60, 60);
    }
    
    private void drawHUD(Graphics graphics){
         //Boss HUD
        graphics.setColor(Color.gray);
        graphics.fillRect(220, 400, 250, 32);
        graphics.setColor(new Color( 255, 50, 100));
        graphics.fillRect(220, 400, health * 2, 32);
        graphics.setColor(Color.black);
        graphics.drawRect(220, 400, 250, 32);
    }
    
    private void collision(){
        
        for(int i = 0; i < handler.object.size(); i++){
            
            GameObjects tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                
                if(getBounds().intersects(tempObject.getBounds())){
                    health-=2;
                    green-=2;
                }           
            }
        } 
    }
}
