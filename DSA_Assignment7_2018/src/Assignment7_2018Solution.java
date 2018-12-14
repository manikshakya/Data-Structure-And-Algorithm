/**
 * student name:
 * student number:
 */
import java.util.*;
public class Assignment7_2018Solution {
	public static void main(String[] args){
    
		
  }
}
//=======================================================
// class Point
final class Point{
	private final int x,y;
	Point(int a, int b){x = a; y = b;}
	public int x(){return x;}
	public int y(){return y;}
	public String toString(){return "("+x+","+y+")";}
	public boolean equals(Object ob){
		if(!(ob instanceof Point)) return false;
		Point p = (Point)ob;
		return x == p.x && y == p.y;
	}
	public int hashCode(){return 31*x*y;}
}


//End class Point
//=======================================================
//HashTable class
class MyHashList<E> implements Iterable<E>{
	private ArrayList<LinkedList<E>> table;
	public MyHashList(int n){
	 // n = the number of lists to create - 
	 // it does not limit the number of elements in the table 
	 table = new ArrayList<>();
   for(int j = 0; j < n; j++)
   	  table.add(new LinkedList<>());
  }
  private int hashC(E x){
		int k = x.hashCode();
		//an alternative is to mask the minus using
		//int k = x.hashCode() & 0x7fffffff;
		int h = Math.abs(k % table.size());
		return(h);
	}
	
	public void add(E x){
		int index = hashC(x);
		table.get(index).addFirst(x);
	}
	public boolean contains(E x){
		int index = hashC(x);
		return(table.get(index).contains(x));
	}
	public boolean remove(E x){
		int index = hashC(x);
		return table.get(index).remove(x);
	}
	
	public int size(){
		int count = 0;
		for(int j = 0; j < table.size();j++) count += table.get(j).size();
		return count;
	}
	public Iterator<E> iterator(){
	  ArrayList<E> items = new ArrayList<E>();
	  int ind = 0;
	  while(ind < table.size()){
			Iterator<E> it = table.get(ind).iterator();
			while(it.hasNext()) items.add(it.next());
			ind++;
	   }
	   return items.iterator();
	}
	public String toString(){return table.toString();} 
	
	
	//Assignment =======================================================
	
	public void remove(List<E> ls){
	  for(E x : ls) this.remove(x); 
	}
	
	public LinkedList<E> getList(E x){	
    if(x == null || !this.contains(x)) return null;
		LinkedList<E> ls = new LinkedList<>();
		int ind = hashC(x);
		ls.addAll(table.get(ind));
		return ls;
	}	
	public boolean equals(Object ob){
	 if(!(ob instanceof MyHashList)) return false;
	 MyHashList<?> hlst = (MyHashList<?>)ob;
	 //define equality if sizes equal and corresponding buckets 
	 //contain the same elements - order of elements not important.
	 if(this.size() != hlst.size()) return false;
	 /*
	 for(int j = 0; j < table.size();j++){
	  if(table.get(j).size() != hlst.table.get(j).size()) return false;
		for(E x : table.get(j))
		 if(!hlst.table.get(j).contains(x)) return false;
	 }*/
	 for(E x : this){
	  int ind = hashC(x);
	  if(!hlst.table.get(ind).contains(x)) return false;
		//if(!hlst.contains(x)) return false;
	 }
	 return true;
	}
	//==================================================================
	//Methods that provide information about the state of the hashtable
	public double percentUsed(){
		int count = 0;
		for(int j = 0; j < table.size(); j++){
			if(table.get(j).size() > 0)
			  count++;
		}
		double p = count *100.0 / table.size();
		return p;
	}
	public int largestBucket(){
		int max = 0;
		for(int j = 0; j < table.size(); j++){
		  int k = table.get(j).size();
			if( k > max) max = k;
		}
		return max;
	}
	public int smallestBucket(){
		int min = table.get(0).size();
		for(int j = 1; j < table.size(); j++){
		  int k = table.get(j).size();
			if(k < min) min = k;
		}
		return min;
	}
	public int[] listSizes(){
		int n = this.largestBucket();
		int d[] = new int[n+1];
		for(int j = 0; j < d.length; j++) d[j] = 0;
		for(int j = 0; j < table.size(); j++){
			int m = table.get(j).size();
			d[m] = d[m] + 1;
		}
		return d;
	}
	public int empty(){
		int count = 0;
		for(int j = 0; j < table.size(); j++)
			if(table.get(j).size() == 0) count++;
		return count;
	}	
	//==================================================================
}