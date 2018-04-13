package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Graphics;
import roundrobin.Timer;


public class DisplayDataState extends State
{
    private Timer timer;
    
    
    public DisplayDataState(Screen monitor, Engine engine) 
    {
        super(monitor, engine);
        timer = new Timer();
    }

    
    @Override
    public void update() 
    {
       if(engine.getKM().isEnter())
       {
           if(timer.isHeadNull()) timer.firstTime();
           else
           {
               
           }
       }
    }

    @Override
    public void draw(Graphics g)
    {
        //System.out.println(timer.isHeadNull());
    } 
    
    //Getters
    public Timer getTimer()
    {
        return timer;
    }
}
