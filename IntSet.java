/*
 * This class maintains a set of ints. 
 */
public class IntSet {
	private Node head;
	private Node tail;
	private int size;
	
	public IntSet()
	{
	}
	
	
	public boolean find(int key)
	{
	    Node pointer = tail;
	    while (pointer != null)
	    {
	        if (pointer.data == key) return true;
	        pointer = pointer.next;
	    }
	    return false;
	}
	
	
	public void insert(int key)
	{
	    if (find(key)) return;
	    
	    Node after = new Node(key);
	    if (head == null) {
        head = after;
        tail = after;
	    }
	    else {
	        after.next = tail;
	        tail = after;
	    }
	    size++;
	}
	
	
	public void remove(int key)
	{
	    if (!find(key)) return; //set is not null and has key
	    
	    Node it = tail;
	    if (head == tail)
	    {
	        head = null;
	        tail = null;
	    }
	    else if (tail.data == key)
	    {
	        tail = it.next;
	    }
	    else if (head.data == key)
	    {
	        while (it.next != head)
	        {
	            it = it.next;
	        }
	        it.next = null;
	        it = head;
	    }
	    else
	    {
	        while (it.next.data != key)
	        {
	            it = it.next;
	        }
	        it.next = it.next.next;
	    }
	    size--;
	}
	
	
	public void print()
	{
	    int smallest = 999999999;
	    int last = -99999999;
	    for (int i = 0; i < size; i++)
	    {
	        Node pointer = tail;
	        while (pointer != null)
	        {
	            if (pointer.data < smallest && pointer.data > last)
	            {
	                smallest = pointer.data;
	            }
	            pointer = pointer.next;
	        }
	        System.out.print(smallest + " ");
	        last = smallest;
	        smallest = 999999999;
	    }
	    System.out.println();
	}
}
