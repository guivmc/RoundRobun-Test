package KeyManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private char charPressed;
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
            return;
        }
        
        charPressed = key;       
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
        char key = ke.getKeyChar();  
        if(key == KeyEvent.VK_ENTER) enter = false;
        charPressed = ' ';
    }
    
    
    //Getters
    public char getCharPressed()
    {
        return charPressed;
    }

    public boolean isEnter() 
    {
        return enter;
    }
       
    //Setters
    public void setCharPressed(char key)
    {
        this.charPressed = key;
    }
    
}
