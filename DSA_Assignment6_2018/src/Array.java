import java.util.*;
public class Array<T extends Comparable<T>> implements Iterable<T>{
	T[] data;
	int size = 0;
	private static final int DEFAULT_SIZE = 50;
	@SuppressWarnings("unchecked")
	public Array(){
		data = (T[])(new Comparable[DEFAULT_SIZE]);
	}
	@SuppressWarnings("unchecked")
	public Array(int n){
		if(n < 0) throw new IllegalArgumentException("Size cannot be negative");
		data = (T[])(new Comparable[n]);
	}
	@SuppressWarnings("unchecked")
	public Array(List<T> lst){
		data = (T[])(new Comparable[DEFAULT_SIZE]);
		for(T x : lst) this.add(x);
	}
	public int size(){return size;}
	public void add(T x){
		if(size < data.length){
		  data[size] = x;
		  size++;
		}
		else{
			@SuppressWarnings("unchecked")
			T[] tmp = (T[])(new Comparable[size+DEFAULT_SIZE]);
			for(int j = 0; j < size; j++) tmp[j] = data[j];
			tmp[size] = x; size++;
			data = tmp;
		}
	}
	public void add(Array<T> lst){
		for(T x : lst) this.add(x);
	}
	public boolean full(){return size == data.length;}
	public boolean contains(T x){
		for(int j = 0; j < size; j++)
			if(data[j].equals(x)) return true;
		return false;
	}
	public void sort(){
		Arrays.sort(data,0,size);
	}
	public void sort(Comparator<? super T> comp){
		Arrays.sort(data,0,size,comp);
	}
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		int k = 0;
		while(k < size-1){
			s = s + data[k]+", ";
			k++;
		} 
	  s = s + data[k]+"]";
	  return s;
	}
	public Iterator<T> iterator(){
		return new ArrayIterator<T>(data,size);
	}
	private class ArrayIterator<T> implements Iterator<T>{
		private T[] d;
		private int index = 0;
		private int size;
		ArrayIterator(T[] dd, int s){
			d = dd;size = s;
		}
		public boolean hasNext(){
			return index < size;
		}
		public T next(){
			if(index == size) throw new NoSuchElementException();
			T item = (T) d[index]; index++;
			return item;
		}
		public void remove(){}
	}
}