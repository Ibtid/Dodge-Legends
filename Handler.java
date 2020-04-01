package dodge.legends;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObjects> object = new LinkedList<GameObjects>();
    
    public void tick(){
       for(int i = 0; i < object.size(); i++){
           GameObjects tempObject = object.get(i);
           
           tempObject.tick();
       }
        
    }
    
    public void render(Graphics graphics){
        for(int i = 0; i < object.size(); i++){
           GameObjects tempObject = object.get(i);
           
           tempObject.render(graphics);
       }
    }
    
    public void clearEnemies(){
        for(int i = 0; i < object.size(); i++){
           GameObjects tempObject = object.get(i);
           
           if(tempObject.getId() == ID.Player){
               object.clear();
               addObject(new Player(tempObject.getX(),tempObject.getY(), ID.Player, this));
           }  
       }
    }
    
    public void addObject(GameObjects object){
        this.object.add(object);
    }
    
    public void removeObject(GameObjects object){
        this.object.remove(object);
    }
}
