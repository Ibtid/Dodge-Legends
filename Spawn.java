package dodge.legends;

import java.util.Random;

public class Spawn {

    Handler handler;
    HUD hud;
    int basicEnemyCount = 1;
    Random r;
    
    private int scoreKeep = 0;
    
    Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        
        if(scoreKeep >= 220){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);
            
            if(hud.getLevel() == 2 || hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 4 || hud.getLevel() == 6){
                handler.addObject(new FastEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.FastEnemy, handler));
            }else if(hud.getLevel() == 5 || hud.getLevel() == 7){
                handler.addObject(new TrapEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.TrapEnemy, handler));
            }else if(hud.getLevel() == 10){
                handler.clearEnemies();
                handler.addObject(new BossEnemy(280,-120,ID.BossEnemy,handler));
            }
        }
    }
}
