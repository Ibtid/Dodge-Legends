package dodge.legends;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObjects{
    
    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    
    private int width, height;

    public Trail(int x, int y, ID id, Color color,float life, int width, int height, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick() {
        if(alpha > life){
            alpha -= life - 0.001f;
        }else handler.removeObject(this);
    }

    @Override
    public void render(Graphics graphics) {
        
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setComposite(makeTransparent(alpha));
        
        graphics.setColor(color);
        graphics.fillOval(x, y, width, height);
        
        graphics2D.setComposite(makeTransparent(1));
        
    }
    
    private AlphaComposite makeTransparent(float alpha){
        
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
        
    }
        
    @Override
    public Rectangle getBounds() {
        return null;
    }

}
