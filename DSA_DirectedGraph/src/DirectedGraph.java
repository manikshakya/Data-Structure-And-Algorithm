import java.util.*;
import java.io.*;
public class DirectedGraph<E extends Comparable<E>>{
	private ArrayList<Pair> graph;
	public DirectedGraph(){
	  graph = new ArrayList<>();
	}
	/*public void createGraph(String fName) throws IOException, FileNotFoundException{
		StringTokenizer st;
		BufferedReader in = new BufferedReader(new FileReader(fName));
		gSize = Integer.parseInt(in.readLine());
		for(int k = 0; k < gSize; k++){
			st = new StringTokenizer(in.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			LinkedList<Integer> ls = new LinkedList<Integer>();
			while(st.hasMoreTokens()){
				int x = Integer.parseInt(st.nextToken());
				ls.add(x); 
			}
			graph.add(ls);
		}
	}*/
	
	public void addNode(E x,List<E> ls){
	  assert x != null && ls != null && unique(ls);
	  if(graph.size() == 0){
	    graph.add(new Pair(x,new ArrayList<E>(ls)));
	    for(E y : ls){
	     if(this.contains(y) == -1)
	       graph.add(new Pair(y,new ArrayList<E>()));
	    }
	  }
	  else{ //graph must contain the node x to ensure that nodes are always connected
	    if(this.contains(x) != -1){
	      int ind = this.contains(x);
	      graph.get(ind).y().addAll(ls);
	      for(E y : ls){
	        if(this.contains(y) == -1)
	          graph.add(new Pair(y,new ArrayList<E>()));
	      }
	    }
	    else //allows construction of non-connected graph - some points may be unreachable
	      graph.add(new Pair(x,new ArrayList<E>()));
	  }  
	}
	private int contains(E x){
	 for(int j = 0; j < graph.size();j++) 
	   if(graph.get(j).x().equals(x)) return j;
	 return -1;
	}
	private boolean unique(List<E> ls){
	 for(int j = 0; j < ls.size();j++)
	   for(int k = j+1; k < ls.size();k++)
	     if(ls.get(j).equals(ls.get(k))) return false;
	 return true;
	}
	public String toString(){return graph.toString();}
	public int NumNodes(){return graph.size();}
	
	private void dft(int v, boolean visited[],List<E> ls){
		visited[v] = true;
		ls.add(graph.get(v).x());
		List<E> nodes = graph.get(v).y();
		for(E x : nodes){
		 int j = this.contains(x); //guaranteed present
		 if(!visited[j]) dft(j,visited,ls);
		}
	}
	public List<E> depthFirstTraversal(){
	  List<E> lst = new ArrayList<>();
		boolean visited[] = new boolean[graph.size()];
		for(int k = 0; k < graph.size(); k++) visited[k] = false;
		for(int vertex = 0; vertex < graph.size(); vertex++){
			if(!visited[vertex])
				dft(vertex,visited,lst);
		}
		return lst;
	}
	
	public List<E> breadthFirstTraversal(){
	  List<E> lst = new ArrayList<>();
		boolean visited[] = new boolean[graph.size()];
		for(int k = 0; k < graph.size(); k++) visited[k] = false;
		LinkedList<Integer> queue = new LinkedList<>();
		for(int vertex = 0; vertex < graph.size(); vertex++){
			if(!visited[vertex]){
				queue.add(vertex);
				visited[vertex] = true;
				lst.add(graph.get(vertex).x());
				while(!queue.isEmpty()){
					int v = queue.getFirst();
					queue.removeFirst();
					for(E x : graph.get(v).y()){
					  int j = this.contains(x);
					  if(!visited[j]){
					    queue.add(j);
						  visited[j] = true;
						  lst.add(x);
					  }
					}
				}
			}
		}
		return lst;
	}
	public boolean isEmpty(){
		return graph.size() == 0;
	}
	private class Pair{	
	  private E x;
	  private List<E> y;
	  Pair(E a, List<E> b){x = a; y = b;}
	  E x(){return x;}
	  List<E> y(){return y;}
	  public String toString(){
		  return "("+x.toString()+"->"+y.toString()+")";
	  }
 }
}