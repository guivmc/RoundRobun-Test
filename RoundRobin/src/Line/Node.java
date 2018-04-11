package Line;


public class Node<Data>
{
    private Data value;
    
    private Node next;
    
    public Node(Data value)
    {
        this.value = value;
        this.next = null;
    }
    
    //Getters
    public Data getValue()
    {
        return value;
    }

    public Node getNext()
    {
        return next;
    }
    
    //Setters
    public void setDado(Data value) 
    {
        this.value = value;
    }

    public void setNext(Node next) 
    {
        this.next = next;
}
}
