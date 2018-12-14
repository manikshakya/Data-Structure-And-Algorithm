import java.util.*;
interface Queue<T>{
	public boolean join(T x);
	public T top();
	public boolean leave();
	public boolean full();
	public boolean empty();
	public void display();
}

public class CircularQueue<T> implements Queue<T>,Iterable<T>{
	private T queue[];
	private int head, tail, size;
	@SuppressWarnings("unchecked")
	public CircularQueue(){
		queue = (T[])new Object[20];
	  head = 0; tail = 0;size = 0;
	}
	@SuppressWarnings("unchecked")
	public CircularQueue(int n){ //assume n >=0
		queue = (T[])new Object[n];
	  size = 0; head = 0; tail = 0;
	}
	public boolean join(T x){
		if(size < queue.length){
			queue[tail] = x;
			tail = (tail+1)%queue.length;
			size++;
			return true;
		}
		else return false;
	}
	public T top(){
		if(size > 0)
			return queue[head];
		else
			return null;
	}
	public boolean leave(){
		if(size == 0) return false;
		else{
			head = (head+1)%queue.length;
			size--;
			return true;
		}
	}
	public boolean full(){
		return (size == queue.length);
	}
	public boolean empty(){
		return (size == 0);
	}
	public String toString(){
		String s = "[";
		int index = head;
		for(int k = 0; k < size-1; k++){
			s = s + queue[index]+", ";
			index = (index+1)%queue.length;
		}
		return s + queue[index]+"]";
	}
	public Iterator<T> iterator(){
		return new QIterator<T>(queue, head, size);
	}
	private static class QIterator<T> implements Iterator<T>{
		private T[] d;
		private int index;
		private int size;
		private int returned = 0;
		QIterator(T[] dd, int head, int s){
			d = dd; index = head; size = s;
		}
		public boolean hasNext(){
			return returned < size;
		}
		public T next(){
			if(returned == size) throw new NoSuchElementException();
			T item = (T)d[index];
			index = (index+1) % d.length;
			returned++;
			return item;
		}
		public void remove(){}
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}