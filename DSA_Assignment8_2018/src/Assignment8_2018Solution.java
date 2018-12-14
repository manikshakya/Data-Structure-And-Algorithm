import java.io.*;
import java.util.*;
import java.util.function.*;
public class Assignment8_2018Solution {
	public static void main(String[] args) {
		ArrayList<Word> wd = new ArrayList<>(Arrays.asList(new Word("apple"),
				new Word("boom"),
				new Word("boom"),
				new Word("crew"),
				new Word("dog"),
				new Word("eon"),
				new Word("fish"),
				new Word("goat"),
				new Word("apple"),
				new Word("mango"),
				new Word("lukaku"),
				new Word("martial"),
				new Word("rashford"),
				new Word("lingard"),
				new Word("young"),
				new Word("de gea"),
				new Word("hererra"),
				new Word("irrationalize"), 
				new Word("lattermost"), 
				new Word("apportion"), 
				new Word("trymata"), 
				new Word("serrulation"), 
				new Word("dirhinous"), 
				new Word("lochia"), 
				new Word("choregraphy"), 
				new Word("amerindian"), 
				new Word("asexualising"), 
				new Word("targitaus"), 
				new Word("perturber"), 
				new Word("cerebral"), 
				new Word("zoser"), 
				new Word("soufflï¿¥ï¾½"), 
				new Word("veuses"), 
				new Word("femaleness"), 
				new Word("reviver"), 
				new Word("delicateness"), 
				new Word("unbonnet"), 
				new Word("uskub"), 
				new Word("superbomb"), 
				new Word("kirkby"), 
				new Word("overmoralize"), 
				new Word("prehunger"), 
				new Word("crisper"), 
				new Word("rubasse"), 
				new Word("jeans"), 
				new Word("cellulitis"), 
				new Word("enslaving"), 
				new Word("edificial"), 
				new Word("overpersecuted"), 
				new Word("itchingly"), 
				new Word("unprobational"), 
				new Word("browser"), 
				new Word("seladang"), 
				new Word("volumeter"), 
				new Word("fath"), 
				new Word("prattlingly"), 
				new Word("subinferring"), 
				new Word("refrozen"), 
				new Word("phylogenesis"), 
				new Word("argosy"), 
				new Word("pistonlike"), 
				new Word("rivet"), 
				new Word("carney"), 
				new Word("sneerer"), 
				new Word("cupric"), 
				new Word("durance"), 
				new Word("materialized"), 
				new Word("assembl"), 
				new Word("centrad"), 
				new Word("perioeci"), 
				new Word("sert"), 
				new Word("nonsusceptibility"), 
				new Word("mollescent"), 
				new Word("overoxidizing"), 
				new Word("lepidus"), 
				new Word("napping"), 
				new Word("cymbal"), 
				new Word("dragline"), 
				new Word("vitalize"), 
				new Word("mollifyingly"), 
				new Word("inappetency"), 
				new Word("lappeted"), 
				new Word("vuninvigorative"), 
				new Word("affectionateness"), 
				new Word("eucalyptol"), 
				new Word("xenophanes"), 
				new Word("stovepipe"), 
				new Word("cancered"), 
				new Word("kayoing"), 
				new Word("neural"), 
				new Word("inessential"), 
				new Word("eccentricity"), 
				new Word("heredia"), 
				new Word("nonbromidic"), 
				new Word("scat"), 
				new Word("sideroscope"), 
				new Word("preaffection"), 
				new Word("nonresponsibleness"), 
				new Word("whom"), 
				new Word("thiophen"), 
				new Word("secretness"), 
				new Word("postethmoid"), 
				new Word("delphinius"), 
				new Word("cooking"), 
				new Word("adroit"), 
				new Word("filings"), 
				new Word("subcast"), 
				new Word("palladium"), 
				new Word("outproduce"), 
				new Word("aromatized"), 
				new Word("businesswoman"), 
				new Word("clavierist"), 
				new Word("whisk"), 
				new Word("keratalgia"), 
				new Word("conceivably"), 
				new Word("synergistic"), 
				new Word("kinetics")));
		
		long start, end;
		
		BinarySearchTree<Word> wds = new BinarySearchTree<>(wd);
		
		start = System.currentTimeMillis();
		
		System.out.println(wds.inOrder());
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
		
		
		start = System.currentTimeMillis();
		
		System.out.println(wds.inOrder());
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
		
		
		

		start = System.currentTimeMillis();
			
		System.out.println(wds.preOrder());
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
		
		start = System.currentTimeMillis();
		
		System.out.println(wds.postOrder());
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
		
		
		start = System.currentTimeMillis();
		
		System.out.println(wds.height());
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
	
		
		start = System.currentTimeMillis();
		
		System.out.println(wds.contains(new Word("superbomb")));
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
		
		
		start = System.currentTimeMillis();
		
		wds.remove(new Word("young"));
		
		System.out.println(wds);
		
		end = System.currentTimeMillis();
		System.out.println("QuickSort Cost: " + (end - start));
		
		System.out.println("Hello World\n\n\n");
		
		
		//ArrayList<Integer> in = new ArrayList<>(Arrays.asList(111,2,345,456,324,1,54,56,4,6,756,3,5));
		
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(9,6,15,4,7,13,17,10,14));
		
		BinarySearchTree<Integer> bin = new BinarySearchTree<>(in);
		System.out.println(bin.maxValue());
		
		System.out.println(bin.leafNodes());
		
		System.out.println(bin.balance());
		
		System.out.println(bin.postOrder());
		
		bin.rotateLeftRoot();
		//bin.rotateRightRoot();
		System.out.println(bin.preOrder());
		
		
		System.out.println(bin.inOrder());
	}
}
class Word implements Comparable<Word>{
	private String word;
	Word(String s){
		assert nonBlank(s);
		word = s;
	}
	public String word(){return word;}
	public String toString(){return word;}
	public int compareTo(Word wd){
		if(wd == null) return -1;
		return word.compareTo(wd.word());
	}
	
	public boolean equals(Object ob){
	 if(!(ob instanceof Word)) return false;
	 Word wd = (Word)ob;
	 return word.equals(wd.word);
	}
	
	private boolean nonBlank(String s){
		for(int j = 0; j < s.length();j++) 
		  if(s.charAt(j) ==' ') return false;
		return true;
	}
}
class BinarySearchTree<E extends Comparable<E>> implements Iterable<E>{
	private BNode<E> root;
	private int count;
	public BinarySearchTree(){
		root = null; count = 0;
	}
	public BinarySearchTree(Collection <? extends E> ls){
		root = null; count = 0;
		for(E x : ls) this.add(x);
	}
	public void add(E x){
	  root = add(root,x);
	}
	private BNode<E> add(BNode<E> rt, E x){
	  if(x == null) return rt; //do not allow null values
		if(rt == null){
			count++;
			return new BNode<E>(x);
		}
		else if(x.compareTo(rt.data()) < 0){
			BNode<E> p = add(rt.left(), x);
			rt.setLeft(p);
			return rt;
		}
		else if(x.compareTo(rt.data()) > 0){
			BNode<E> p = add(rt.right(), x);
			rt.setRight(p);
			return rt;
		}
		else // x present, so no change
			return rt;
	}
	public boolean contains(E x){
		return contains(root, x);
	}
	private boolean contains(BNode<E> rt, E x){
		if(rt == null) return false;
		else{
			if(rt.data().equals(x)) return true;
			else if(x.compareTo(rt.data()) < 0)
				return contains(rt.left(),x);
			else
				return contains(rt.right(), x);
		}
	}
	public int size(){
		return count;
	}

	public void remove(E x){
		BNode<E> ptr = null; BNode<E> parentPtr = null;
		if(root != null){
			ptr = root; parentPtr = root;
			boolean found = false;
			while(ptr != null && !found){
				if(ptr.data().equals(x)) found = true;
				else{
					parentPtr = ptr;
					if(x.compareTo(ptr.data()) < 0)
						ptr = ptr.left();
					else
						ptr = ptr.right();
				}
			}
			if(found){
				count--;
				if(ptr == root){
					root = removeNode(root);
				}
				else{
					if(x.compareTo(parentPtr.data()) < 0){
						BNode<E> n = removeNode(parentPtr.left());
						parentPtr.setLeft(n);
					}
					else{
						BNode<E> n = removeNode(parentPtr.right());
						parentPtr.setRight(n);
					}
				}
			}
		}
	}
	private BNode<E> removeNode(BNode<E> rt){
		if(rt == null) return null;
		else if (rt.left() == null && rt.right() == null)
			return null;
		else if(rt.left() == null)
			return rt.right();
		else if(rt.right() == null){
			return rt.left();
		}
		else{
			BNode<E> ptr = rt.left();
			BNode<E> parentPtr = null;
			while(ptr.right() != null){
				parentPtr = ptr; ptr = ptr.right();
			}
			rt.set(ptr.data());
			if(parentPtr == null)
				rt.setLeft(ptr.left());
			else
				parentPtr.setRight(ptr.left());
			return rt;
		}
	}
	public int height(){
		return height(root);
	}
	private int height(BNode<E> rt){
		if(rt == null) return -1;
		else{
			return 1 + max(height(rt.left()),height(rt.right()));
		}
	}
	private int max(int a,int b){ return a >= b? a:b;}

	public ArrayList<E> inOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		inOrder(root,lst);
		return lst;
	}
	private void inOrder(BNode<E> rt, ArrayList<E> lst){
	 if(rt != null){
		 inOrder(rt.left(), lst);
		 lst.add(rt.data());
		 inOrder(rt.right(),lst);
	 }
	}
	public ArrayList<E> preOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		preOrder(root,lst);
		return lst;
	}
	private void preOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			lst.add(rt.data());
			preOrder(rt.left(), lst);
			preOrder(rt.right(),lst);
		 }
	}
	public ArrayList<E> postOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		postOrder(root,lst);
		return lst;
	}
	private void postOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			postOrder(rt.left(), lst);
			postOrder(rt.right(),lst);
			lst.add(rt.data());
		 }
	}
	public Iterator<E> iterator(){
		ArrayList<E> ls = this.inOrder();
		return ls.iterator();
	}
	public String toString(){
		return this.inOrder().toString();
	}
	//Assignment solutions ============================
	public E maxValue(){
	 if(root == null) return null;
	 BNode<E> pt = root;
	 while(pt.right() != null) pt = pt.right();
	 return pt.data();
	}
  public List<E> leafNodes(){
	 if(root == null) return null;
	 List<E> lst = new ArrayList<>();
	 getLeafNodes(root,lst);
	 return lst;
	}
	private void getLeafNodes(BNode<E> rt, List<E> ls){
	 if(rt != null){
	   getLeafNodes(rt.left(),ls);
		 //check if leaf node
		 if(rt.left() == null && rt.right() == null)
		  ls.add(rt.data());
		 getLeafNodes(rt.right(),ls);
	 }
	}	
	public int balance(){
		if(root == null) return 0;
		return countNodes(root.left) - countNodes(root.right);
	}
	private int countNodes(BNode<E> rt){
		if(rt == null) return 0;
		else return 1 + countNodes(rt.left()) + countNodes(rt.right());
	}
	
	public void rotateLeftRoot(){
		if(root.right() != null){
			BNode<E> newRt = root.right();
			root.setRight(newRt.left());
			newRt.setLeft(root);
			root = newRt;
		}
	}
	
	public void rotateRightRoot(){
		if(root.left() != null){
			BNode<E> newLt = root.left();
			root.setLeft(newLt.right());
			newLt.setRight(root);
			root = newLt;
		}
	}
	
	public void rotateRightAt(E x){
		
	}
	
	private BNode<E> rotateRightAtNode(BNode<E> rt){
		
		return null;
	}
	
  
	//=================================================
	private class BNode<E extends Comparable<E>>{
	 	private E data;
	 	private BNode<E> left;
		private BNode<E> right;
		public BNode(E d){
			data = d; left = null; right = null;
		}
		public E data(){return data;}
		public void set(E x){data = x;}
		public BNode<E> left(){ return left;}
		public BNode<E> right(){return right;}
		public void setLeft(BNode<E> k){left = k;}
		public void setRight(BNode<E> k){right =k;}
 }
}