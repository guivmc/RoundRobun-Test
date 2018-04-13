package States;

import Control.Engine;
import Screen.Screen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import roundrobin.Timer;
import roundrobin.Process;


public class InsertState extends State implements ActionListener
{
    private String steps[] = {"Insert quantum: ", "Insert Name: ", "Insert Arraival: ", "Insert Duration: ", "Insert I,0: "};
    
    private JFrame frame;
    private JPanel panel;
    private JTextField text;
    private String JText = "";
    
    private DisplayDataState dds;
    private Process p = new Process(); 
    
    private int step = 0;
    
    public InsertState(Screen monitor, Engine engine) 
    {
        super(monitor, engine);
        
        dds = new DisplayDataState(monitor, engine);
        
        frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        
        text = new JTextField(7);
        //text.addActionListener(actionPerformed());
        text.addActionListener(this);
        
        
        panel.add(text);
    
        frame.add(panel);
        
        frame.pack();
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) 
    {
       JText = text.getText();
       switch(step)
        {
            case 0: // insert quantum
                int aux = Integer.parseInt(JText);//myChar - '0';
                dds.getTimer().setQuantum(aux);
                step++;
                break;
            case 1: //InsertProcess Name
                p.setName(JText);
                step++;
                break;
            case 2: //InsertProcess Arraival
                p.setArrival(Integer.parseInt(JText));
                step++;
                break;
            case 3: //InsertProcess Duration
                p.setDuration(Integer.parseInt(JText));
                step++;
                break;
            case 4: //InsertProcess i/o
                if(JText.equals("go"))
                {
                    dds.getTimer().insertProcess(p);
                    frame.setVisible(false);
                    State.setState(dds);
                    break;
                }
                if(JText.equals("new"))
                {
                    dds.getTimer().insertProcess(p);
                    p = new Process();
                    step = 1;
                    break;
                }
                p.insertIO(Integer.parseInt(JText));
                break;
        }
    }

    @Override
    public void update() 
    {     
        
           
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(Color.yellow);
        g.setFont(font);
        // g.drawString(sb.toString(), 0, 500);
        g.drawString(steps[step], 100, 100);
        g.drawString(JText, 500, 100);
    }   
}
