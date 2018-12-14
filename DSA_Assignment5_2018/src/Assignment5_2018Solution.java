/**
 * Student name:
 *
 * Student number:
 */
 /*
 For Assignment 5 please complete the methods listed below for class LinkedListHT. In each case the comment 
 inserted in the method describes its purpose. 
 */
import java.util.*;

public class Assignment5_2018Solution {
  public static void main(String[] args) {
    //Test code here=========================================
    LinkedListHT lst = new LinkedListHT();
		lst.addHead(5);lst.addHead(7);lst.addTail(7);
    System.out.println(lst);
		//lst.delAll(7);
		System.out.println(lst);
		lst.addTail(8);lst.addTail(9);
		//lst.reverse();
		System.out.println(lst);
		
		System.out.println(lst.max());
		System.out.println(lst.min());
		
    //======================================================
  }
}
class LinkedListHT{
	private Node head = null; 
	private Node tail = null; 
	//empty list
	public void addTail(int x){
		Node nw = new Node(x);
		if(head == null){
			head = nw; tail = nw;
		}
		else{
	    tail.setNext(nw);
		  tail = nw;
		}
	}
	public void addTail(int f[]){
	 for(int x : f) this.addTail(x);
	}
	public void addHead(int x){
  	//insert x at head of list
		Node nw = new Node(x);
		if(head == null){
		  head = nw; tail = nw;
		}
		else{
		 nw.setNext(head);
		 head = nw;
		}
  }
	public void addHead(int f[]){
	 for(int x : f) this.addHead(x);
	}
	public void delTail(){
	  if(head == tail){
		 head = null; tail = null;
		}
		else{
		  Node k = head;
		  while(k.next() != tail) k = k.next();
		  k.setNext(null);
		  tail = k;
		}
	}
  //=====================================================
	public int size(){
		int count = 0;
		Node p = head;
		while(p != null){count++; p = p.next();}
		return count;
	}
	public void delHead(){
    if(head == tail){
      head = null; tail = null;
    }
    else
     head = head.next();
	}
	public void delAll(int x){
		//delete all occurrences of x from the list
		Node k = head; Node bk = head;
		while(k != null){
			if(k.data() == x){ //found
			   if(k == head){
				   head = k.next();
				   bk = k; k = k.next();
				 }
			   else if(k == tail){
			    bk.setNext(null);
			    tail = bk;
					k = k.next();
			   }
			   else{
				  bk.setNext(k.next());
				  k = k.next();
				 }
			}
		  else {bk = k; k = k.next();}
		}
	}
	public int sum(){
		int sum = 0;
		Node p = head;
		while(p != null){sum += p.data(); p = p.next();}
		return sum;
	}
	public int sumEven(){
		//calculate sum of even values in the list
		int sum = 0;
		Node p = head;
		while(p != null){
		  if(p.data() % 2 == 0) sum += p.data(); 
		  p = p.next();
		}
		return sum;
	}
	public int count(int x){
		//count number of occurrences of x in list
		Node p = head; int count = 0;
		while(p != null) if(p.data() == x) count++;
		return count;
	}
	
	public void addTail(LinkedListHT lst){
    	//add given list to tail of existing list
    	if(lst == null) return;
    	Node p = lst.head;
    	while(p != null) this.addTail(p.data());
  } 
  public int[] toArray(){ 
    if(head == null) return null;
  	int f[] = new int[this.size()];
  	Node p = head; int j = 0;
  	while(p != null){
  		f[j] = p.data();
  		j++; p = p.next();
  	}
  	return f;
  }
	public void reverse(){
		//reverse using pointers only
		if(head == tail) return;
		tail = head;
		Node prev = null;
    Node nHead = head;
    while (nHead != null) {
        Node next = nHead.next();
        nHead.setNext(prev);
        prev = nHead;
        nHead = next;
    }
    head = prev;
	}
	public boolean equals(Object ob){
		if(!(ob instanceof LinkedListHT)) return false;
		LinkedListHT lst = (LinkedListHT)ob;
		if(this.size() != lst.size()) return false;
		Node p = head; Node p1 = lst.head;
		while(p != null && p.data() == p1.data()){
			p = p.next(); p1 = p1.next();
		}
		if(p == null) return true;
		else return false;
	}
	
	public int max(){
		// max - returns largest value in list, 
        // Integer.MIN_VALUE if empty
		if(head == null) return Integer.MIN_VALUE;
		
		Node current = head; int max = head.data();
		while(current != null){
			if(max < current.data()){
				max = current.data();
			}
			current = current.next();
		}
		
		return max;
	}
	
	public int min(){
		// max - returns largest value in list, 
        // Integer.MIN_VALUE if empty
		if(head == null) return Integer.MAX_VALUE;
		
		Node current = head; int min = head.data();
		while(current != null){
			if(min > current.data()){
				min = current.data();
			}
			current = current.next();
		}
		
		return min;
	}
	//=================================================
	public boolean contains(int x){
		Node k = head;
		boolean found = false;
		while(k != null && !found){
			if(k.data() == x) found = true;
			else k = k.next();
		}
		return found;
	}
	
	public void remove(int x){
		Node k = head; Node bk = head;
		boolean found = false;
		while(k != null && !found){
			if(k.data() == x) found = true;
			else{ bk = k; k = k.next();}
		}
		if(found){
			if(k == head)
				head = k.next();
			else if(k == tail){
			   bk.setNext(null);
			   tail = bk;
			}
			else
				bk.setNext(k.next());
		}
	}
	public void remove(int f[]){
	 for(int x : f) this.remove(x);
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
/*
Add following methods to your class:
1. max - returns largest value in list, 
         Integer.MIN_VALUE if empty
2. min - returns smallest value, Integer.Max_VALUE if empty
2. allEqual - returns true if all elements the same
3. getList(int lb, int ub) - returns list of values 
                             in range lb..ub
4. addTail(int x, int n) - insert x n times at tail of list
5. insert(int x, int pos) - insert x at position pos in list
                            if pos == 0 insert at head;
														if pos > size insert at tail
6. unique - returns true if all values different
7. isSorted - returns true if values in list are sorted in 
              ascending order; true if list empty
*/