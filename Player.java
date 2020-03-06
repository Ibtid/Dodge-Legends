
package dodge.legends;

import java.awt.Color;
import java.awt.Graphics;



public class Player extends GameObjects{

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics graphics) {
        
        graphics.setColor(Color.yellow);
        graphics.fillOval(x, y, 32, 32);
        
    }
    
    

}
