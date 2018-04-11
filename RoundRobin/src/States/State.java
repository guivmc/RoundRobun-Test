package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Font;
import java.awt.Graphics;

public abstract class State 
{    
    
    private static State currentState = null;
   
   
    public static void setState (State s)
    {
        currentState = s;
    }
    
    public static State getState()
    {
        return currentState;
    }
    
    protected Engine engine;
    protected Screen monitor;
    protected Font font = new Font("TimesRoman", Font.PLAIN, 45);
    
    public State(Screen monitor, Engine engine)
    {
        this.engine = engine;
        this.monitor = monitor;
    }
    
    public abstract void update();
    
    public abstract void draw(Graphics g);
}
