package dodge.legends;

import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObjects{

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics graphics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle (x, y, 16, 16);
    }
    
}
