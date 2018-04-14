package roundrobin;

import Line.Line;
import java.util.ArrayList;


public class Timer 
{
    private int currentTime = 0, quantum, counter = 0;
    private Process currentProcess = null;
    private Line waitingLine = new Line();
    private ArrayList<Process> array = new ArrayList<>();
    private String time = "", line = "Fila: ", cpu = "CPU: ";
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
        while(currentProcess == null)
        {
            time = "Tempo: " + currentTime;
            currentProcess = checkForArraival();  ; 
            currentTime++;
        }
        cpu += currentProcess.getName() + "(" + currentProcess.getDuration() + ")"; 
    }
    
    public Process checkForArraival()
    {
         for (int i = 0; i < array.size(); i++) 
         {
            Process p = array.get(i);
            if(p.getArrival() == currentTime)
            {
                time += " chegada de processo " + p.getName();
                names.add(names.size(), p.getName());
                array.remove(i);
                return p;
            }
         }  
         return null;
    }
    
    public void calculate()
    {
        time = "Tempo: " + currentTime;
        if(counter < quantum)
        {
            counter++;
            Process check = checkForArraival();
            if(check != null) waitingLine.enqueue(check);
            
            if (currentProcess.getIO().getHead() != null)
            {
                if((int) (currentProcess.getIO().getHead().getValue()) == currentProcess.getTotalProcessed())
                {
                
                }
            }
            
            //System.out.println(counter);
        }
        else 
        {
            counter = 0;
            System.out.println("foi");
        }   
        currentTime++;
//        if(counter < quantum)
//        {  
//            time = "Tempo: " + currentTime;
//            if(!currentProcess.getIO().isEmpty())
//            {
//                if((int) (currentProcess.getIO().getHead().getValue()) == currentProcess.getTotalProcessed())
//                {
//                    currentProcess.getIO().dequeue();
//                    waitingLine.dequeue();
//                    waitingLine.enqueue(currentProcess);
//                    if(waitingLine.isEmpty())
//                    {
//                        currentProcess = null;
//                    }
//                    else
//                    {
//                        time += " operacao de I/O " + currentProcess.getName();
//                        names.add(names.size(), currentProcess.getName());
//                        names.remove(0);
//                        currentProcess = (Process) waitingLine.getHead().getValue();
//                    }                
//                }
//            }
//            
//            checkForArraival();
//            line = "Fila: " + getNames();
//            currentProcess.setDuration(currentProcess.getDuration() - 1);
//            currentProcess.setTotalProcessed(currentProcess.getDuration() + 1);
//            if(currentProcess.getDuration() == 0)
//            {
//                if(waitingLine.isEmpty())
//                    {
//                        currentProcess = null;
//                    }
//                    else
//                    {
//                        time += " fim do processo " + currentProcess.getName();
//                        if(!names.isEmpty()) names.remove(0);
//                        currentProcess = (Process) waitingLine.getHead().getValue();
//                    }  
//                
//            }
//            if(!isCurrentProcessNull())cpu = "CPU: " + currentProcess.getName() + "(" + currentProcess.getDuration() + ")";
//            else cpu =  "CPU: ";
//            
//        }
//        else counter = 0;
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
        for (int i = 1; i < names.size(); i++) 
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
