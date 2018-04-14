package roundrobin;

import Line.Line;
import java.util.ArrayList;


public class Timer 
{
    private int currentTime = 0, quantum, counter = 0;
    private Process currentProcess = null;
    private Line waitingLine = new Line();
    private ArrayList<Process> array = new ArrayList<>();
    private String time = "", line = "", cpu = "";
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
    
    public void putFirstProcess()
    {
        if(array.isEmpty()) return;   
        //GetProcess First
        if(currentProcess == null)
        {
            for (int i = 0; i < array.size(); i++) 
            {
                Process p = array.get(i);
                if(p.getArrival() == currentTime)
                {
                    //waitingLine.enqueue(p);
                    currentProcess = p;
                    time = "Tempo: " + currentTime + " chegada de " + p.getName();
                    line = "Fila: ";
                    cpu = "CPU: " + p.getName() + "(" + p.getDuration() + ")";           
                    array.remove(i);
                    break;
                }
                time = "Tempo: " + currentTime;
                line=  "\nFila: ";
                cpu = "CPU: ";        
                currentTime++;
            }  
        }
    }
    
    public void checkForArraival()
    {
         for (int i = 0; i < array.size(); i++) 
            {
                Process p = array.get(i);
                if(p.getArrival() == currentTime)
                {
                    time +=  " chegada de processo " + p.getName();
                    names.add(names.size(), p.getName());
                    waitingLine.enqueue(p);
                    array.remove(i);
                    break;
                }
            }  
    }
    
    public void calculate()
    {
        if(counter < quantum)
        {  
            time = "Tempo: " + currentTime;
            if(!currentProcess.getIO().isEmpty())
            {
                if((int) (currentProcess.getIO().getHead().getValue()) == currentProcess.getTotalProcessed())
                {
                    currentProcess.getIO().dequeue();
                    waitingLine.dequeue();
                    waitingLine.enqueue(currentProcess);
                    if(waitingLine.isEmpty())
                    {
                        currentProcess = null;
                    }
                    else
                    {
                        time += " operacao de I/O " + currentProcess.getName();
                        names.add(names.size(), currentProcess.getName());
                        currentProcess = (Process) waitingLine.getHead().getValue();
                    }                
                }
            }
            
            checkForArraival();
            line = "Fila: " + getNames();
            currentProcess.setDuration(currentProcess.getDuration() - 1);
            if(currentProcess.getDuration() == 0)
            {
                if(waitingLine.isEmpty())
                    {
                        currentProcess = null;
                    }
                    else
                    {
                        time += " operacao de I/O " + currentProcess.getName();
                        names.add(names.size(), currentProcess.getName());
                        currentProcess = (Process) waitingLine.getHead().getValue();
                    }          
            }
            if(!isCurrentProcessNull())cpu = "CPU: " + currentProcess.getName() + "(" + currentProcess.getDuration() + ")";
            else cpu =  "CPU: ";
            currentTime++;
        }
        else counter = 0;
    }
    
    //Bools
    public boolean isCurrentProcessNull()
    {
        return (currentProcess == null);
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
    
    public String getTimeOutput()
    {
        return time;
    }
    
    public String getLineOutPut()
    {
        return line;
    }
    
    public String getCPUOutout()
    {
        return cpu;
    }

    public int getCounter() 
    {
        return counter;
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

    public void setCounter(int counter) 
    {
        this.counter = counter;
    }   
}
