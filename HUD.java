package dodge.legends;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class HUD {

    public static int HEALTH = 100;
    private int greenValue;
    
    private int score = 0;
    private int level = 1;

    public void tick() {
        
        HEALTH = DodgeLegends.clamp(HEALTH, 0, 100);
        greenValue = HEALTH*2;
        
        score++;

    }

    public void render(Graphics graphics) {
        //Health Bar
        graphics.setColor(Color.gray);
        graphics.fillRect(15, 15, 200, 32);
        graphics.setColor(new Color( 150, greenValue, 30));
        graphics.fillRect(15, 15, HEALTH * 2, 32);
        graphics.setColor(Color.white);
        graphics.drawRect(15, 15, 200, 32);
        
        //Score
        graphics.setColor(new Color(153,255,255));
        graphics.setFont(new Font("serif", Font.BOLD, 15));
        graphics.drawString("SCORE: " +score, 500, 24);
        
        //level
        graphics.setColor(new Color(153,255,255));
        graphics.setFont(new Font("serif", Font.BOLD, 25));
        graphics.drawString("Level: " +level, 500, 50);
    }

    public int getScore() {
        return score;
    }

    public void score(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
}
