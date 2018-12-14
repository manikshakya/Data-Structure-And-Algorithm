public class TowersOfHanoi{
  public static void main(String args[]){
	towers(7,'A','B','C');
	System.out.println();
	System.out.println(Counter.count());
  }
  
  
  
  static void towers(int num, char source, char dest, char spare){
     if (num == 1){
        System.out.printf("\n Move disk 1 from peg %c to peg %c", source, dest);
        Counter.inc();
        return;
     }
     towers(num - 1, source, spare, dest);
     System.out.printf("\n Move disk %d from peg %c to peg %c", num, source, dest);
     towers(num - 1, spare, dest, source);
     
     Counter.inc();
     
  }
}

class Counter{
	private Counter(){}
	private static int count = 0;
	
	public static void inc(){
		count++;
	}
	public static int count(){ return count;}
}