import java.util.*;
public class IntLinkedList{
	private Node head = null;
	public void add(int x){ //add at head
		Node nw = new Node(x);
		nw.setNext(head);
		head = nw;
	}
	public boolean contains(int x){
		Node k = head;
		boolean found = false;
		while(k != null && !found){
			if(k.data() == x) found = true;
			else k = k.next();
		}
		return found;
	}
	public void delHead(){
    if(head != null)
    	head = head.next();
	}
	public void remove(int x){
		Node k = head; Node bk = head;
		boolean found = false;
		while(k != null && !found){
			if(k.data() == x) found = true;
			else{ bk = k; k = k.next();}
		}
		if(found)
			if(k == head)
				head = k.next();
			else
			  bk.setNext(k.next());
	}
	
	public int size(){
	    Node k = head;
	    int len = 0;
	    while(k != null){
			  len++; k = k.next();
	    }
	    return len;
	}
	
	public boolean modify(int x, int nx){
	   //find and replace x with nx
	   Node k = head;
	   boolean found = false;
	   while(k != null && !found){
				if(k.data() == x){
	    		k.set(nx);
		    	found = true;
				}
				else k = k.next();
	   }
	   return found;
	}
  public int[] toArray(){
    	int f[] = new int[this.size()];
    	Node k = head; int j = 0;
    	while(k != null){
    		f[j] = k.data();
    		k = k.next(); j = j + 1;
    	}
    	return f;
  }
	public void sort(){
		int f[] = this.toArray();
		Arrays.sort(f);
		head = null;
		//insert largest first to create ascending list
		for(int j = f.length; j > 0; j--) this.add(f[j-1]);
  }

	public String toString(){
	  if(head == null) return "[]";
		String s = "[";
		Node k = head;
		while(k.next() != null){
			s = s + k.data()+", ";
			k = k.next();
		}
		s = s + k.data()+"]";
		return s;
	}
	private class Node{
		int data;
		Node next;
		public Node(int x){
			data = x; next = null;
		}
		public Node next(){return next;}
		public void setNext(Node p){
			next = p;
		}
		public void set(int x){data = x;}
		public int data(){return data;}
	}
}