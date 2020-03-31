package dodge.legends;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private Handler handler;
    private boolean[] keyDown = new boolean[4];
       
    public KeyInput(Handler handler){
       this.handler = handler;
       
       keyDown[0]=false;
       keyDown[1]=false;
       keyDown[2]=false;
       keyDown[3]=false;
    }
       
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
           
        for(int i=0; i < handler.object.size(); i++){
            GameObjects tempObject = handler.object.get(i);
               
            if(tempObject.getId() == ID.Player){
                   
                if (key == KeyEvent.VK_W){ 
                    tempObject.setVelocityY(-6);
                    keyDown[0] = true;
                }
       
                if (key == KeyEvent.VK_S){
                    tempObject.setVelocityY(6);
                    keyDown[1] = true;
                }
                   
                if (key == KeyEvent.VK_D){ 
                    tempObject.setVelocityX(6);
                    keyDown[2] = true;
                }
                    
                if (key == KeyEvent.VK_A){ 
                    tempObject.setVelocityX(-6);
                    keyDown[3] = true; 
                }
                     
            }
        }
            if(key == KeyEvent.VK_ESCAPE)System.exit(1);     
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
           
        for(int i=0; i < handler.object.size(); i++){
            GameObjects tempObject = handler.object.get(i);
               
            if(tempObject.getId() == ID.Player){
                    
                if (key == KeyEvent.VK_W) 
                    keyDown[0] = false;
                if (key == KeyEvent.VK_S) 
                    keyDown[1] = false;
                if (key == KeyEvent.VK_D) 
                    keyDown[2] = false;
                if (key == KeyEvent.VK_A)
                    keyDown[3] = false;
                        
                if(!keyDown[0]&&!keyDown[1]) tempObject.setVelocityY(0);
                if(!keyDown[2]&& !keyDown[3]) tempObject.setVelocityX(0);
            }    
        }
    }
}
