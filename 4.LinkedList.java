package pa4;

public class LinkedList {    
    //Represent a node of the singly linked list    
    public class Node{    
        private int data;    
        private Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    //Represent the head and tail of the singly linked list    
    private Node head = null;    
    private Node tail = null;    
    private int size=0;
        
    //addNode() will add a new node to the list    
    public void addNode(int data) {    
        //Create a new node    
    	Node newNode = new Node(data);    
        size++;
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
    
    public int getLast(int idx) {
    	Node p = head;
    	for (int i=0; i<idx; i++)
    		p = p.next;
    	return p.data;
    }
    
    public void removeFirst() {
        if (size == 0) {
          System.out.println("List is empty");
        } else if (size == 1) {
          head = tail = null;
          size--;
        } else {
          head = head.next;
          size--;
        }
      }
    
    public int size() {
    	return size;
    }
    
  
  public void removeLast() {
	  if (head != null) {
	    if (head != tail) {
	      Node p = head;
	      for (int i = 0; i < size - 2; i++)
	        p = p.next;
	      tail = p;
	      p.next = null;
	    } else
	      head = tail = null;
	    size--;
	  }
  }
  
}    