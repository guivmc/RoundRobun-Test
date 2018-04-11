package Screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class Screen 
{
    private JFrame frame;
    private Canvas canvas;
    private Dimension screenSize;
    
    private String title;
    
    public Screen()
    {
        title = "Round Robin";
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        createFrame();
    }
    
    public void createFrame()
    {
        //create and set JFrame
        frame = new JFrame(title);
        frame.setSize(screenSize);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create and set canvas
        canvas = new Canvas();
        canvas.setPreferredSize(screenSize);
        canvas.setMaximumSize(screenSize);
        canvas.setMinimumSize(screenSize);
        canvas.setFocusable(false);
        canvas.setBackground(Color.black);
        
        //add canvas to the JFrame
        frame.add(canvas);
        frame.pack();
    }
    
    //Getters
     public Canvas getCanvas()
    {
        return canvas;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public int getWidth()
    {
        return (int) screenSize.getWidth();
    }
    
    public int getHeight()
    {
        return (int) screenSize.getHeight();
    }
}
