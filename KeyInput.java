
package dodge.legends;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
       
        public KeyInput(Handler handler){
            this.handler = handler;
        }
       
        public void KeyPressed(KeyEvent e){
            int key = e.getKeyCode();
           
            for(int i=0; i < handler.object.size(); i++){
                GameObjects tempObject = handler.object.get(i);
               
                if(tempObject.getId() == ID.Player){
                    //key events for player 1
                    if (key == KeyEvent.VK_W) tempObject.setVelocityY(-5);
                    if (key == KeyEvent.VK_S) tempObject.setVelocityY(5);
                    if (key == KeyEvent.VK_D) tempObject.setVelocityY(5);
                    if (key == KeyEvent.VK_A) tempObject.setVelocityY(-5);
                }
            }
           
         
                   
        }
        public void KeyReleased(KeyEvent e){
          int key = e.getKeyCode();
           
            for(int i=0; i < handler.object.size(); i++){
                GameObjects tempObject = handler.object.get(i);
               
                if(tempObject.getId() == ID.Player){
                    //key events for player 1
                    if (key == KeyEvent.VK_W) tempObject.setVelocityY(0);
                    if (key == KeyEvent.VK_S) tempObject.setVelocityY(0);
                    if (key == KeyEvent.VK_D) tempObject.setVelocityY(0);
                    if (key == KeyEvent.VK_A) tempObject.setVelocityY(0);
                }
                 
            }
        }
}
