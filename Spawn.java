package dodge.legends;

public class Spawn {

    Handler handler;
    HUD hud;
    int basicEnemyCount = 1;
    
    private int scoreKeep = 0;
    
    Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        
        if(scoreKeep >= 100){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);
            
            if(hud.getLevel()== 2){
                handler.addObject(new BasicEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.BasicEnemy, handler));
            }else if(hud.getLevel()== 3){
                handler.addObject(new BasicEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.BasicEnemy, handler));
            }else if(hud.getLevel()== 4){
                handler.addObject(new FastEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.FastEnemy, handler));
            }else if(hud.getLevel()== 5){
                handler.addObject(new TrapEnemy(DodgeLegends.width/34, DodgeLegends.height/40, ID.TrapEnemy, handler));
            }
        }
    }
}
