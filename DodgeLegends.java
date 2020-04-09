 package dodge.legends;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class DodgeLegends extends Canvas implements Runnable{

    public static final int width = 640, height  = width / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    Music music;
    
    public enum STATE {
        Menu,
        Help,
        Game,
        End
    };
    
    public static STATE gameState = STATE.Menu;
    
    public DodgeLegends(){
        
        hud = new HUD();
        handler = new Handler();
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        
        Window window = new  Window(width, height, "Dodge Legends", this);
        
        
        spawner = new Spawn(handler, hud);
        r = new Random();
        
        if(gameState == STATE.Game){
            handler.clearEnemies();
            //handler.addObject(new BasicEnemy(width/34, height/40, ID.BasicEnemy, handler));
            //handler.addObject(new Player(width/2-32,height/2-32, ID.Player, handler));
        }else{
            for(int i = 0; i<10; i ++){
                handler.addObject(new MenuParticle(r.nextInt(width), r.nextInt(height), ID.MenuParticle, handler));
            
            }
        }
        
        
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
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        music.playMusic("Music\\\\bgmusic.wav");
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
        
        if(gameState == STATE.Game){    
            hud.tick();
            spawner.tick();
            if(HUD.playerHEALTH<=0){
                //HUD.playerHEALTH = 100;
                //hud.setScore(0);
                //hud.setLevel(1);
                gameState = STATE.End;
                handler.clearEnemies(); 
                for(int i = 0; i<10; i ++){
                handler.addObject(new MenuParticle(r.nextInt(width), r.nextInt(height), ID.MenuParticle, handler));
            
                }
            }
        }else if(gameState == STATE.Menu || gameState == STATE.End){
            menu.tick();
        }
            
    }
    
    private void render(){
        
        BufferStrategy bufferstrategy = this.getBufferStrategy();
        if(bufferstrategy == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics graphics = bufferstrategy.getDrawGraphics();
            
        if(gameState == STATE.Game){
            graphics.setColor(new Color(224,224,224));
            graphics.fillRect(0, 0, width, height);
        }else{
            graphics.setColor(new Color(0,0,0));
            graphics.fillRect(0, 0, width, height);
        }
       
        
        handler.render(graphics);
        
        if(gameState == STATE.Game){
            
            hud.render(graphics);
            
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){
            
            menu.render(graphics);
            
        }
        
        
        graphics.dispose();
        bufferstrategy.show();
        
    }
    
     public static int clamp (int var, int min, int max){
        if(var >= max)
            return var = max ;
        else if(var <= min)
            return var = min;
        else
            return var;
    }
    
}
