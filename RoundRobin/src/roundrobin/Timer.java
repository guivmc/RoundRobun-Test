package roundrobin;

import Line.Line;
import Line.Node;


public class Timer 
{
    private int currentTime = 0, quantum, counter = 0;
    private Process currentProcess = null;
    private Line waitingLine = new Line(), names = new Line(), chart = new Line();
    private String time = "", line = "Fila: ", cpu = "CPU: ";
   
    public Timer(int quantum)
    {
        this.quantum = quantum;
    }

    public Timer(){}
    
    //void
    public void insertProcess(Process p)
    {
        //inserir na tabela
        chart.enqueue(p);
    }
    
    //Pega o primeiro processo que chega
    public void putFirstProcess()
    {
        if(chart.isEmpty()) return;
        //GetProcess First
        while(currentProcess == null)
        {
            time = "Tempo: " + currentTime;
            checkForArraival();
            if(waitingLine.getHead() != null)  currentProcess = (Process) waitingLine.dequeue();
            currentTime++;
        }
        cpu += currentProcess.getName() + "(" + currentProcess.getDuration() + ")"; 
    }
    
    //Checa se outro processo chegou
    public void checkForArraival()
    {
        Node aux = chart.getHead();
        while(aux != null)
        {
            Process p = (Process) aux.getValue();
            if(p.getArrival() == currentTime)
            {
                time += " chegada de processo " + p.getName();
                names.enqueue(p.getName());
                chart.dequeue();
                waitingLine.enqueue(p);
            }
            aux = aux.getNext();
        } 
    }
    
    //Executa processo
    public void calculate()
    {
        time = "Tempo: " + currentTime;
        if(counter < quantum)
        {
            loop: 
            {
                counter++;
                checkForArraival();
                
                //checa se o processo tem I/O
                if (currentProcess.getIO().getHead() != null)
                {
                    if((int) (currentProcess.getIO().getHead().getValue()) - 1 == currentProcess.getTotalProcessed())
                    {                    
                        if(waitingLine.getHead() != null)
                        {   // Se sim troca de processo se possivel
                            time += " operação de I/O de " + currentProcess.getName();
                            names.enqueue(currentProcess.getName());
                            names.dequeue();
                            waitingLine.enqueue(currentProcess);
                            currentProcess.getIO().dequeue();
                            currentProcess = (Process) waitingLine.dequeue();
                            counter = 0;
                            break loop;
                        }   
                    }
                }

                //Checa se o processo acabou
                if(currentProcess.getDuration() - 1 == 0)
                {   
                    time += " fim do processo " + currentProcess.getName();
                    if(waitingLine.getHead() != null)
                    {   //Checa se ha outros processos na fila de espera
                        currentProcess = (Process) waitingLine.dequeue();
                        names.dequeue();
                    } //Caso nao, entao fim
                    else time = "Tempo: Fim da simulação";
                    counter = 0;
                    break loop;
                }
                currentProcess.compute();
            }
        }
        else 
        {   //Checa se o processo acabou
            if(currentProcess.getDuration() - 1 == 0)
            {
                time += " fim do processo " + currentProcess.getName();
                if(waitingLine.getHead() != null) 
                { //Checa se ha outros processos na fila de espera
                    currentProcess = (Process) waitingLine.dequeue();
                    names.dequeue();
                } //Caso nao, entao fim
                else time = "Tempo: Fim da simulação";
            }
            counter = 0;
        }
        cpu = "CPU: " + currentProcess.getName() + "(" + currentProcess.getDuration() + ")"; 
        line = "Fila: " + getNames();
        currentTime++;
    }
    
    //Bools
    public boolean isCurrentProcessNull()
    {
        return (currentProcess == null);
    }
    
    //Strings  
    public String getNames()
    {   //Pega os nomes dos processos que estao na fila de espera
        Node aux = names.getHead().getNext(); 
        String out = " ";
        while(aux != null)
        {
            String s = (String) aux.getValue();
            out += s + " - ";
            aux = aux.getNext();
        }
        return out;
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
