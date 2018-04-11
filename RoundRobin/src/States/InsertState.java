package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Color;
import java.awt.Graphics;
import roundrobin.Timer;


public class InsertState extends State
{
    private StringBuilder sb = new StringBuilder();
    private char myChar;
    
    private Timer timer;
    
    private int step = 0;
    
    public InsertState(Screen monitor, Engine engine) 
    {
        super(monitor, engine);
    }

    @Override
    public void update() 
    {
           myChar = engine.getKM().getCharPressed();
      
           if(myChar != ' ')
           {               
                sb.append(myChar);
           }
                
           if(engine.getKM().isEnter())
           {
                switch(step)
                {
                    case 0: // insert quantum
                        int aux = Integer.parseInt(sb.toString());//myChar - '0';
                        timer = new Timer(aux);
                        //System.out.println(timer.getQuantum());
                        sb.setLength(0);
                        //System.out.println(sb.toString());
                        step++;
                        break;
                    case 1: //InsertProcess
                        if(sb.toString().equals("go")) System.out.println("foi");
                        break;
                }
                // System.out.println(sb.toString());
                myChar = ' ';
            }            
            // System.out.println(step);
           
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(Color.yellow);
        g.setFont(font);
        // g.drawString(sb.toString(), 0, 500);
        g.drawString("Insert quantum: ", 100, 100);
        g.drawString(sb.toString(), 500, 100);
    }   
}
