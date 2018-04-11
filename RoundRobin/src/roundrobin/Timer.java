package roundrobin;

import Line.Line;


public class Timer 
{
    private int currentTime, quantum;
    private Process currentProcess;
    private Line waitingLine;
    
    public Timer(int quantum)
    {
        this.quantum = quantum;
    }

    public Timer(){}
    
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
