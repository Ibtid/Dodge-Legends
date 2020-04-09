package dodge.legends;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter{
    
    private DodgeLegends dodgeLegends;
    private Handler handler;
    private HUD hud;
    private Random r;
    //Music music;
               
    public Menu(DodgeLegends dodgeLegends, Handler handler, HUD hud){
        
        this.dodgeLegends = dodgeLegends;
        this.handler = handler;
        this.hud = hud;
         
        
    }
    
    public void mousePressed(MouseEvent e){
        int mx  =   e.getX();
        int my  =   e.getY();
        
        if (dodgeLegends.gameState == DodgeLegends.STATE.Menu) {
            //play button
            if (mouseOver(mx, my, DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 10, 195, 64)) {
                dodgeLegends.gameState = DodgeLegends.STATE.Game;
                handler.addObject(new Player(DodgeLegends.width / 2 - 32, DodgeLegends.height / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(DodgeLegends.width / 34, DodgeLegends.height / 40, ID.BasicEnemy, handler));
                }

            //help button
            if (mouseOver(mx, my, DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 90, 195, 64)) {
                dodgeLegends.gameState = DodgeLegends.STATE.Help;

            }

            //quit button
            if (mouseOver(mx, my, DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 170, 195, 64)) {
                System.exit(1);
            }
        }

        //Back from help
        if (dodgeLegends.gameState == DodgeLegends.STATE.Help) {
            if (mouseOver(mx, my, DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 170, 195, 64)) {
                dodgeLegends.gameState = DodgeLegends.STATE.Menu;
                return;
            }
        }
        
        if (dodgeLegends.gameState == DodgeLegends.STATE.End) {
            if (mouseOver(mx, my, DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 170, 195, 64)) {
                dodgeLegends.gameState = DodgeLegends.STATE.Menu;
                hud.setScore(0);
                hud.setLevel(0);
                hud.playerHEALTH = 100;
                return;
            }
        }
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x &&  mx < x+width){
            if(my>y && my < y+height){
                return true;
            }else return false; 
        }else return false;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics graphics){
        
        if (dodgeLegends.gameState == DodgeLegends.STATE.Menu) {
            //music.playMusic("Music\\\\strings.wav");

            
            //tittle
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawOval(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 - 80, 195, 64);
            
            graphics.setColor(new Color(255, 255, 255));   
            graphics.setFont(new Font("sherif", Font.BOLD, 30));
            graphics.drawString("DODGELEGENDS", DodgeLegends.width / 2 - 115, DodgeLegends.height / 4 - 30);

            //start button
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawRect(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 10, 195, 64);
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("Helvetica", Font.BOLD, 30));
            graphics.drawString("START", DodgeLegends.width / 2 - 35, DodgeLegends.height / 4 + 50);

            //help button
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawRect(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 90, 195, 64);
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("Helvetica", Font.BOLD, 30));
            graphics.drawString("HELP", DodgeLegends.width / 2 - 35, DodgeLegends.height / 4 + 130);

            //Quit button
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawRect(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 170, 195, 64);
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("Helvetica", Font.BOLD, 30));
            graphics.drawString(" QUIT", DodgeLegends.width / 2 - 35, DodgeLegends.height / 4 + 210);
        }
        
        //Help Section
        
        else if(dodgeLegends.gameState == DodgeLegends.STATE.Help){
            //Help tittle
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawOval(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 - 80, 195, 64);
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("sherif", Font.BOLD, 50));
            graphics.drawString("HELP", DodgeLegends.width / 2 - 65, DodgeLegends.height / 4 - 30);
            
            //Advice
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("sherif", Font.BOLD, 20));
            graphics.drawString("Use W, A, S, D to protect the player from enemies", 75, 200);

            //Back Button
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawRect(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 170, 195, 64);
            graphics.setFont(new Font("Helvetica", Font.BOLD, 30));
            graphics.drawString("BACK", DodgeLegends.width / 2 - 35, DodgeLegends.height / 4 + 210);
        }
        
        //GAMEOVER
        
        else if(dodgeLegends.gameState == DodgeLegends.STATE.End){
            //tittle
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawOval(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 - 80, 195, 64);
            
            graphics.setColor(new Color(255, 255, 255));   
            graphics.setFont(new Font("sherif", Font.BOLD, 30));
            graphics.drawString("DODGELEGENDS", DodgeLegends.width / 2 - 115, DodgeLegends.height / 4 - 30);

            //Result
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("sherif", Font.BOLD, 20));
            graphics.drawString("GAMEOVER", 270, 190);
            
            //Advice
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("sherif", Font.BOLD, 20));
            graphics.drawString("YOUR SCORE: " +hud.getScore(), 220, 230);

            //Back Button
            graphics.setColor(new Color(255, 255, 255));
            graphics.drawRect(DodgeLegends.width / 2 - 90, DodgeLegends.height / 4 + 170, 195, 64);
            graphics.setFont(new Font("Helvetica", Font.BOLD, 25));
            graphics.drawString("PLAY AGAIN", DodgeLegends.width / 2 - 65, DodgeLegends.height / 4 + 210);
        }
    } 
}