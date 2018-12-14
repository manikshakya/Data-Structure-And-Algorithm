import java.util.*;
public class PolishNotationTest {
    public static void main(String args[]){
    	//Read expression in infix notation and output in reverse Polish notation
    	StackList<String> stOp = new StackList<String>();
    	CircularQueue<String> rpn = new CircularQueue<String>(100);
    	Scanner in = new Scanner(System.in);
    	String infix = in.nextLine();
    	//System.out.println(infix);
    	StringTokenizer tk = new StringTokenizer(infix);
    	while(tk.hasMoreTokens()){
    		String op = tk.nextToken();
    		//System.out.print(op);
    		if(isOperator(op)){
    			if(stOp.empty())
    				stOp.push(op);
    			else{
    				while(stOp.empty() == false && priority(stOp.top()) >= priority(op)){
    					String temp = stOp.top();
    					stOp.pop();
    					rpn.join(temp);
    				}
    				stOp.push(op);
    			}
    		}
    		else if(op.equals("(")){ stOp.push(op);}
    		else if(op.equals(")")){
    		  	while(!(stOp.top().equals("("))){
    		  		rpn.join(stOp.top());
    		  		stOp.pop();
    		  	}
    		  	stOp.pop();
    		}
    		else //op == operand
    		  	rpn.join(op);
    	}
    	while(!stOp.empty()){
    		rpn.join(stOp.top());
    		stOp.pop();
    	}
    	rpn.display();
    	//Now apply Polish algorithm to calculate value of expression
    	StackList<Integer> result = new StackList<Integer>();
    	while(!rpn.empty()){
    		String op = rpn.top(); rpn.leave();
    		if(isOperator(op)){
    			int a = result.top(); result.pop();
    			int b = result.top(); result.pop();
    			int x;
    			if(op.equals("*")) x = b * a;
    			else if(op.equals("/")) x = b / a;
    			else if(op.equals("+")) x = b + a;
    			else x = b - a;
    			result.push(x);
    		}
    		else{
    			Integer x = Integer.parseInt(op);
    			result.push(x);
    		}
    	}
    	System.out.println();
    	System.out.println(result.top());
    }
    static boolean isOperator(String op){
    	if(op.equals("*"))
    		return true;
   		else if(op.equals("/"))
    		return true;
    	else if(op.equals("+"))
    		return true;
    	else if(op.equals("-"))
    		return true;
    	else
    		return false;
    }
    static int priority(String k){
    	if(k.equals("*") || k.equals("/"))
    		return 2;
    	else if(k.equals("+") || k.equals("-"))
    		return 1;
    	else
    		return 0;
    }
}
interface Stack1<E>{
	public boolean push(E x);
	public boolean pop();
	public E top();
	public boolean empty();
	public boolean full();
}

class StackList<E> implements Stack1<E>{
	Node<E> head;
	int size = 0;
	public StackList(){
		head = null;
	}
	public boolean push(E x){//add at head
		Node<E> nw = new Node<E>(x);
		nw.setNext(head);
		head = nw; size++;
		return true;
	}
	public boolean pop(){
	 if(size > 0){ //remove at head
		 head = head.next();
		 size--;
		 return true;
	 }
	 else return false;
	}
	public E top(){
		if(size > 0) return head.data();
		else return null;
	}
	public boolean empty(){
		return size == 0; // or head == null
	}
	public boolean full(){
		return false;
	}
	public String toString(){
		String s = "";
		Node<E> t = head;
		while(t != null){
			s = s + t.data().toString()+" ";
			t = t.next();
		}
		return s;
	}
}
class Node<E>{
	E data;
	Node<E> next;
	public Node(E x){
		data = x; next = null;
	}
	public Node<E> next(){return next;}
	public void setNext(Node<E> p){
		next = p;
	}
	public void set(E x){data = x;}
	public E data(){return data;}
}
interface Queue1<T>{
	public boolean join(T x);
	public T top();
	public boolean leave();
	public boolean full();
	public boolean empty();
	public void display();
}
class CircularQueue<T> implements Queue1<T>{
	private T queue[];
	private int head, tail, size;
	public CircularQueue(){
		queue = (T[])new Object[20];
	  head = 0; tail = 0;size = 0;
	}
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
	public void display(){
		System.out.print("[");
		int index = head;
		for(int k = 0; k < size-1; k++){
			System.out.print(queue[index].toString()+", ");
			index = (index+1)%queue.length;
		}
		System.out.print(queue[index].toString()+"]");
	}
}

/*

//Algorithm description
while(more tokens){
   t = next token
   if(t is an operand) append to output queue
   else if(t is an operator){
      while(priority of operator k at top of stack >= priority of t){
	     pop k and append it to output queue
	  }
	  push t on stack
	}
    else if(t is left bracket) push t on stack
    else if(t is right bracked){
       pop operstors at top of stack appending them to output queue
       until left bracket reached
    }
  }
  pop remaining operators from stack and append to output queue
  */