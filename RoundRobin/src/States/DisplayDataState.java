package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Color;
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
           if(timer.isCurrentProcessNull()) timer.putFirstProcess();
           else
           {
               //timer.setCurrentTime(timer.getCurrentTime() + 1);
               timer.calculate();
           }
//           else
//           {
//               timer.setCounter(timer.getCounter() + 1);
//               timer.calculate();
//           }
           
       }
    }

    @Override
    public void draw(Graphics g)
    { 
        g.setColor(Color.yellow);
        g.setFont(font);
        //System.out.println(timer.isHeadNull());
        g.drawString(timer.getTimeOutput(),  monitor.getWidth()/2 - 200,  monitor.getHeight()/2);
        g.drawString(timer.getLineOutPut(),  monitor.getWidth()/2 - 200,  monitor.getHeight()/2 + 40);
        g.drawString(timer.getCPUOutout(),  monitor.getWidth()/2 - 200,  monitor.getHeight()/2 + 80);
    } 
    
    //Getters
    public Timer getTimer()
    {
        return timer;
    }
}
