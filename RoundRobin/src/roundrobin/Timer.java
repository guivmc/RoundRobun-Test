package roundrobin;

import Line.Line;
import java.util.ArrayList;


public class Timer 
{
    private int currentTime = 0, quantum;
    private Process currentProcess;
    private Line<Process> waitingLine = new Line();
    private ArrayList<Process> array = new ArrayList<>();
    private String out = "";
    private ArrayList<String> names = new ArrayList<>();
    
    public Timer(int quantum)
    {
        this.quantum = quantum;
    }

    public Timer(){}
    
    //void
    public void insertProcess(Process p)
    {
        array.add(p);
    }
    
    public void firstTime()
    {
        if(array.isEmpty()) return;   
        //GetProcess First
        if(waitingLine.getHead() == null)
        {
            for (int i = 0; i < array.size(); i++) 
            {
                Process p = array.get(i);
                if(p.getArrival() == currentTime)
                {
                    waitingLine.enqueue(p);
                    names.add(p.getName());
                    out = "Tempo: " + currentTime + " chegada de " + p.getName() +
                    "\nFila: " + getNames() + "\n" +
                    "CPU: " + p.getName() + "(" + p.getDuration() + ")";           
                    array.remove(i);
                    break;
                }
                currentTime++;
            }  
        }
    }
    
    //Bools
    public boolean isHeadNull()
    {
        return (waitingLine.getHead() == null);
    }
    
    //Strings  
    public String getNames()
    {
        String s = "";
        for (int i = 0; i < names.size(); i++) 
        {
            s += names.get(i) + " - ";
        }
        
        return s;
    }
    
    //Getters
    public int getCurrentTime() 
    {
        return currentTime;
    }

    public int getQuantum() 
    {
        return quantum;
    }

    public Process getCurrentProcess() 
    {
        return currentProcess;
    }
    
    public String getOutput()
    {
        return out;
    }
    
    //Setters
    public void setCurrentTime(int currentTime)
    {
        this.currentTime = currentTime;
    }

    public void setQuantum(int quantum) 
    {
        this.quantum = quantum;
    }

    public void setCurrentProcess(Process currentProcess) 
    {
        this.currentProcess = currentProcess;
    }
    
}
