package Control;

import KeyManager.KeyManager;
import Screen.Screen;
import States.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable
{
    private boolean running = false;
    
    //Graphical stuff
    private Thread thread;
    private Screen display;
    private BufferStrategy bs;
    private Graphics g;
    
    private State menu;
    private KeyManager km;
    
    
    public Engine()
    {
        display = new Screen();
        display.getCanvas().createBufferStrategy(3);
        km = new KeyManager();
        display.getFrame().addKeyListener(km);
        menu = new MenuState(display, this);
        State.setState(menu);
    }
    
    
    public void update()
    {
        State.getState().update();
    }
    
    public void draw()
    {
        bs = display.getCanvas().getBufferStrategy();
        
        g = bs.getDrawGraphics();
        
        g.clearRect(0, 0, display.getWidth(), display.getHeight());   
        
        State.getState().draw(g);
        
        bs.show();
        g.dispose();
    }
    
    
    public void run()
    {
       //FPS
       int fps = 10;
       double timePerUpdate = 1000000000 / fps;
       double delta = 0;
       long now;
       long lastTime = System.nanoTime();
       
        while(running)
        {
           //FPS
           now = System.nanoTime();
           delta += (now - lastTime) / timePerUpdate;
           lastTime = now;
           
           if(delta >= 1)
           {               
               update();
               draw();
               delta--;
           }
        }
        
        stop();
    }
    
    public synchronized void start()
    {
        if(running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        //call run();
        thread.start();
    }
    
    //Stop that thread
    public synchronized void stop()
    {
        if(!running)
        {
            return;
        }
        running = false;
        try 
        {
            thread.join();
        } 
        catch (InterruptedException ex) 
        {
            //Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    
    //Getters
    public KeyManager getKM()
    {
        return km;
    }
}
