package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State
{ 
    
    public MenuState(Screen monitor, Engine engine)
    {
        super(monitor, engine);          
    }
    @Override
    public void update() 
    {
        if(engine.getKM().isEnter())
        {
           // State insert = new InsertState(this.monitor, this.engine);
            State.setState(new InsertState(this.monitor, this.engine));
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.yellow);
        g.setFont(font);
        
        g.drawString("Round Robin", monitor.getWidth()/2 - 80, 65);
        g.drawString("Guilherme (21002514)", monitor.getWidth()/2 - 160, 400);
        g.drawString("Diony (20781283)", monitor.getWidth()/2 - 100, 460);
       
    }   
}
