package dodge.legends;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class DodgeLegends extends Canvas implements Runnable {

    public static final int width = 640, height  = width / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    
    public DodgeLegends(){
        
        //handler = new Handler();
       // r = new Random();
        this.addKeyListener(new KeyInput( handler ));
        handler = new Handler();
        Window window = new  Window(width, height, "Dodge Legends", this);
        
        r = new Random();
        
        handler.addObject(new Player(width/2-32,height/2-32, ID.Player));
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
     public synchronized void stop(){
        try{
        thread.join();
        running = false;
        
        }catch(Exception e){
           e.printStackTrace();
        }
            
    }
    
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
               // System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        handler.tick();
    }
    
    private void render(){
        
        BufferStrategy bufferstrategy = this.getBufferStrategy();
        if(bufferstrategy == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics graphics = bufferstrategy.getDrawGraphics();
            
        
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, width, height);
        
        handler.render(graphics);
        
        graphics.dispose();
        bufferstrategy.show();
        
    }
    
}
