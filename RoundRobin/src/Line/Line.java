package Line;

public class Line<inLine>
{
   private Node head, tail;
   
   public Line()
   {
       head = tail = null;
   }
   
   //bools
   public boolean isEmpty()
   {
       return (head == null);
   }
   
    //voids
    public void enqueue(int value)
    {
        Node new_node = new Node(value);    
        
        if(isEmpty()) 
        {
            head = tail = new_node;
            return;
        }
        
        tail.setNext(new_node);
        tail = new_node;
    }
    
    //ints
    public inLine dequeue()
    {
        if(isEmpty()) return null;
        if(head == tail)
        {
            inLine aux = (inLine) head.getValue();
            head = tail = null;
            return aux;
        }     
        
        Node aux = head;
        head = head.getNext();
        return (inLine) aux.getValue();
    }
    
    //Getters
    public Node head()
    {
        return head;
    }
}
