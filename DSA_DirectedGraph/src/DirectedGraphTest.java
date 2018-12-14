import java.util.*;
import java.io.*;
public class DirectedGraphTest{
	public static void main(String[] args) {
		DirectedGraph<Integer> g1 = new DirectedGraph<>();
	  g1.addNode(0,new ArrayList<Integer>(Arrays.asList(1,5)));
	  g1.addNode(1,new ArrayList<Integer>(Arrays.asList(2,3,5)));
	  g1.addNode(2,new ArrayList<Integer>(Arrays.asList(4)));
	  g1.addNode(3,new ArrayList<Integer>());
	  g1.addNode(4,new ArrayList<Integer>(Arrays.asList(3)));
	  g1.addNode(5,new ArrayList<Integer>(Arrays.asList(6)));
	  g1.addNode(6,new ArrayList<Integer>(Arrays.asList(8)));
	  g1.addNode(7,new ArrayList<Integer>(Arrays.asList(3,8)));
	  g1.addNode(8,new ArrayList<Integer>(Arrays.asList(10)));
	  g1.addNode(9,new ArrayList<Integer>(Arrays.asList(4,7,10)));
	  g1.addNode(10,new ArrayList<Integer>());
	  System.out.println(g1);
	  System.out.println(g1.depthFirstTraversal()); 
	  System.out.println(g1.breadthFirstTraversal());
	}
}
