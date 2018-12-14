/**
 * Student name:
 * Student number:
 */
import java.util.*;
public class Assignment6_2018Solution{
  public static void main(String[] args) {
   
  }
}

interface Stack<E>{
	public boolean push(E x);
	public boolean pop();
	public E top();
	public boolean empty();
	public boolean full();
  public Iterator<E> iterator();
}

// MySTack<E> attributes =========================

class MyStack<E> implements Stack<E>,Iterable<E>{
  private List<E> stack;
	private int maxSize;
	MyStack(int ms){
		stack = new ArrayList<E>();
		maxSize = ms;
	}
	public boolean push(E x){ //adds at the head
	 	if(stack.size() == maxSize)return false;
	 	stack.add(x);
	 	return true;
	}
	public boolean pop(){
		if(stack.size() == 0){
			return false;
		}
		stack.remove(stack.size()-1);
		return true;
	}
	public E top(){
		if(stack.size() > 0){
			return stack.get(stack.size()-1);
		}
		return null;
	}
	public boolean empty(){
		return stack.isEmpty();
	}
	public boolean full(){
		if(stack.size() == maxSize){
			return true;
		}
		return false;
	}
	public Iterator<E> iterator(){
	  List<E> tmp = new ArrayList<>();
		int ind = stack.size();
		while(ind > 0){
		  tmp.add(stack.get(ind-1));
			ind--;
		}
		return tmp.iterator();
	}
	public String toString(){
	  int sz = stack.size()-1;
    String s = "[";
    for (int i = 0; i < stack.size()-1; i++)
      s += stack.get(sz-i)+", ";
    s +=  stack.get(0)+ " ]";
    return s;
  }
}

//Queue<T> interface and MyQueue<E> attributes =======
interface Queue<T>{
	public boolean join(T x);
	public T top();
	public boolean leave();
	public boolean full();
	public boolean empty();
	public String toString();
	public boolean contains(T x); 
	public Iterator<T> iterator();
}

class MyQueue<E> implements Queue<E>,Iterable<E>{
  	private ArrayDeque<E> queue;
	private int maxSize;
	public MyQueue(int ms){
		queue = new ArrayDeque<E>();
		maxSize = ms;
	}
	public boolean join(E x){
		if(queue.size() == maxSize)return false;
		queue.addLast(x);
		return true;
	}
	public E top(){
		if(queue.size() == 0)	return null;
		return queue.getFirst();
	}
	public boolean leave(){
		if(queue.size() == 0) return false;
		queue.pollFirst();
		return true;
	}
	public boolean full(){
		return queue.size() == maxSize;
	}
	public boolean empty(){
		return queue.isEmpty();
	}
	public boolean contains(E x){
		return queue.contains(x);
	}

	public String toString(){
		return queue.toString();
	}
	public Iterator<E> iterator(){
		return queue.iterator();
	}
}