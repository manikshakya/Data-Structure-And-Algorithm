package application;

/*
 * Student name: Manik Shakya
 *
 * Student number: 2869290
 
 */
import java.util.*; 
public class Assignment1_2018{
	public static void main(String args[]){
	  //test print
		//print(0,10000);
		//System.out.println();
		
		print1(0,10);
		
		System.out.println();
		
		//========================================
		//test sum
		System.out.println(sum(1, 5));
		System.out.println(sum1(1, 5, 0));
		//========================================
		
		
		//test printBinary
		 printBinary(21); System.out.println();
		 printBinary(50); System.out.println();
		 printBinary(100); System.out.println();
		 printBinary(127); System.out.println();
		 printBinary(1000); System.out.println();
		 printBinary(99999); System.out.println();
		 printBinary(3); System.out.println();
		 printBinary(2048); System.out.println();
		//========================================
	}
	static void print(int a, int b){ //assume a <= b
		if(a<=b){
			int x = b;
			print(a,--b);
			System.out.print(x + " ");
		}	
	}
	static void print1(int a, int b){
		if(a < b){
			System.out.print(a+" ");
			print1(a+1,b);
		}
		else System.out.print(b);
	}
	static int sum(int a, int b){
	  if(a == b) return a;
	  else return (a + sum(a+1,b));
  }
	static int sum1(int a, int b, int sum){
		if(a > b) return sum;
		
		return sum1(a+1, b, sum + a);
	}

	static void printBinary(int x){
		String s = "";
		if(x > 1){
			s = Integer.toString(x % 2) + "";
			//System.out.print(s);
			printBinary(x/2);
			
		}else{
			if(x == 1) s += "1";
			if(x == 0) s += "0";
		}
		
		System.out.print(new StringBuilder(s).reverse().toString());
		
		
	}
	
}
