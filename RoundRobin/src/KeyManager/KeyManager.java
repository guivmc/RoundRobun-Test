package KeyManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private boolean enter = false;
    
    @Override
    public void keyTyped(KeyEvent ke) 
    {
       
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        char key = ke.getKeyChar();  
        
        if(key == KeyEvent.VK_ENTER)
        {
            enter = true;
        }         
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
        char key = ke.getKeyChar();  
        if(key == KeyEvent.VK_ENTER) enter = false;
    }
    
    
    public boolean isEnter() 
    {
        return enter;
    }   
}
