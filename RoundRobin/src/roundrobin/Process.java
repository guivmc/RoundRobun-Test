package roundrobin;

import Line.Line;

public class Process 
{
    private String name;
    private int duration = 0, arrival = 0;
    private Line io;
    
    public Process(String name, int duration, int arrival)
    {
        this.arrival = arrival;
        this.duration = duration;
        this.name = name;
        io = new Line();
    }
    
    public Process()
    {
        io = new Line();
    }
    
    //voids
    public void insertIO(int inOut)
    {
        io.enqueue(inOut);
    }
    
    //Getters
    public String getName() 
    {
        return name;
    }

    public int getDuration() 
    {
        return duration;
    }

    public int getArrival() 
    {
        return arrival;
    }
    
    //Setters
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setDuration(int duration) 
    {
        this.duration = duration;
    }

    public void setArrival(int arrival) 
    {
        this.arrival = arrival;
    } 
}
