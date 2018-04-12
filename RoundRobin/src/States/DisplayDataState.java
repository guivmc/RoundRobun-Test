package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Graphics;
import roundrobin.Timer;


public class DisplayDataState extends State
{
    private Timer timer;
    
    
    public DisplayDataState(Screen monitor, Engine engine, Timer timer) 
    {
        super(monitor, engine);
        this.timer = timer;
    }

    @Override
    public void update() 
    {
       
    }

    @Override
    public void draw(Graphics g)
    {
        
    }
    
}
