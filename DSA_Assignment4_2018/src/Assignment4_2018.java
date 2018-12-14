/*
Assignment 4

Student name: Manik Shakya
Student number: 2869290
===========================================================================

Your task this week is to benchmark three fast sorting algorithms Mergesort,
Quicksort and Arrays.sort (that uses the dual-pivot quicksort described in Yaroslavskiy 2009)


Please note that marks will be awarded based on the quality of the report written by you
in the sections provided below.


*/

/*=======================================================================================
*  Benchmarking Report for each of the sorting algorithms
=========================================================================================
*   MergeSort
*  What type of CPU: Intel core i5
 Amount of Memory: 4 GB
 Speed of processor: 2.5GHz
Test1
Data size: N =60000000
data randomly generated based on N
Cost MergeSort :  


Repeated K times: average costs
Comparative analysis based on data
*  =======================================================================================
*   QuickSort
* What type of CPU: Intel core i5
 Amount of Memory: 4 GB
 Speed of processor: 2.5GHz
Test1
Data size: N =60000000
data randomly generated based on N
Cost Insertion Sort : 
Cost Selection Sort :

Repeated K times: average costs
Comparative analysis based on data
*
*
* ========================================================================================
*  Arrays.sort
* What type of CPU: Intel core i5
 Amount of Memory: 4 GB
 Speed of processor: 2.5GHz
Test1
Data size: N =60000000
data randomly generated based on N
Cost Insertion Sort : 
Cost Selection Sort :

Repeated K times: average costs
Comparative analysis based on data
*
*
* ========================================================================================
*  Comparison based on your test results
* 
*
*
*/ 
//=====================================================================================  

import java.util.*;
class Assignment4_2018{
  static int N = 50000000;
  public static void main(String args[]){
	  long start, end;
	  int dt[] = new int[N];

  /*=======================================================================================
  *  Benchmarking Report for each of the sorting algorithms
  =========================================================================================
  *   MergeSort
  *  What type of CPU: Intel core i5
 Amount of Memory: 4 GB
 Speed of processor: 2.5GHz
  Test1
  Data size: N =60000000
  data randomly generated based on N
  Cost MergeSort : 16904
  

  Repeated K times: average costs
  Comparative analysis based on data
  *  =======================================================================================
  *   QuickSort
  * What type of CPU: Intel core i5
 Amount of Memory: 4 GB
 Speed of processor: 2.5GHz
  Test1
  Data size: N =60000000
  data randomly generated based on N
  Cost QuickSort : 10130
  

  Repeated K times: average costs
  Comparative analysis based on data
  *
  *
  * ========================================================================================
  *  Arrays.sort
  * What type of CPU: Intel core i5
 Amount of Memory: 4 GB
 Speed of processor: 2.5GHz
  Test1
  Data size: N =60000000
  data randomly generated based on N
  Cost Arrays.Sort : 7186
  

  Repeated K times: average costs
  Comparative analysis based on data
  *
  *
  * ========================================================================================
  *  Comparison based on your test results
  * 
  *	Arrays.sort is much faster based on random numbers.
  *
  */ 
  //=====================================================================================
	  System.out.println("Randomly Generated:");
	  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
	  
	 //==========================================================
    //Benchmarking QuickSort code
	  start = System.currentTimeMillis();
	  quickSort(dt, 0, dt.length);
	  end = System.currentTimeMillis();
	  System.out.println("QuickSort Cost: " + (end - start));
	  
	  
	  
    //==========================================================
    // Benchmarking MergeSort code
	  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
	  start = System.currentTimeMillis();
	  mergeSort(dt, 0, dt.length);
	  end = System.currentTimeMillis();
	  System.out.println("MergeSort Cost: " + (end - start));

    //==========================================================
    //Benchmarking Arrays.sort
	  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
	  start = System.currentTimeMillis();
	  Arrays.sort(dt);
	  end = System.currentTimeMillis();
	  System.out.println("Arrays.Sort Cost: " + (end - start));

    //==========================================================
	  
  /*=======================================================================================
   *  Benchmarking Report for each of the sorting algorithms
   =========================================================================================
   *   MergeSort
   *  What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =60000000
   data are in decending order
   Cost MergeSort : 16286
   

   Repeated K times: average costs
   Comparative analysis based on data
   *  =======================================================================================
   *   QuickSort
   * What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =60000000
   data are in decending order
   Cost QuickSort : 3735
   

   Repeated K times: average costs
   Comparative analysis based on data
   *
   *
   * ========================================================================================
   *  Arrays.sort
   * What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =60000000
   data are in decending order
   Cost Arrays.Sort : 7255
   

   Repeated K times: average costs
   Comparative analysis based on data
   *
   *
   * ========================================================================================
   *  Comparison based on your test results
   * 
   *	Quicksort is faster when sorting decending order.
   *
   */ 
   //=====================================================================================
	  
	  
	  System.out.println("\nDecending Order:");
	  for(int j = 0; j < N; j++) dt[j] = N - j;
	  
	  //==========================================================
	    //Benchmarking QuickSort code
		  start = System.currentTimeMillis();
		  quickSort(dt, 0, dt.length);
		  end = System.currentTimeMillis();
		  System.out.println("QuickSort Cost: " + (end - start));
		  
		  
		  
	    //==========================================================
	    // Benchmarking MergeSort code
		  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
		  start = System.currentTimeMillis();
		  mergeSort(dt, 0, dt.length);
		  end = System.currentTimeMillis();
		  System.out.println("MergeSort Cost: " + (end - start));

	    //==========================================================
	    //Benchmarking Arrays.sort
		  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
		  start = System.currentTimeMillis();
		  Arrays.sort(dt);
		  end = System.currentTimeMillis();
		  System.out.println("Arrays.Sort Cost: " + (end - start));

	    //==========================================================
		  
  /*=======================================================================================
   *  Benchmarking Report for each of the sorting algorithms
   =========================================================================================
   *   MergeSort
   *  What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =60000000
   Large value followed by small value and so on
   Cost MergeSort : 15344
   

   Repeated K times: average costs
   Comparative analysis based on data
   *  =======================================================================================
   *   QuickSort
   * What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =60000000
   Large value followed by small value and so on
   Cost QuickSort : 6032
   

   Repeated K times: average costs
   Comparative analysis based on data
   *
   *
   * ========================================================================================
   *  Arrays.sort
   * What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =60000000
   Large value followed by small value and so on
   Cost Arrays.Sort : 7153
   

   Repeated K times: average costs
   Comparative analysis based on data
   *
   *
   * ========================================================================================
   *  Comparison based on your test results
   * 
   *	Quicksort is faster.
   *
   */ 
   //=====================================================================================
		  
		  System.out.println("\nSmall value between two large numbers:");
		  for(int i = 0; i < N; i++){
			  if(i % 2 == 0){
				  dt[i] = (int)(Math.random() * N);
			  }else{
				  dt[i] = (int)(Math.random() * 20);
			  }
		  }
		//==========================================================
		    //Benchmarking QuickSort code
			  start = System.currentTimeMillis();
			  quickSort(dt, 0, dt.length);
			  end = System.currentTimeMillis();
			  System.out.println("QuickSort Cost: " + (end - start));
			  
			  
			  
		    //==========================================================
		    // Benchmarking MergeSort code
			  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
			  start = System.currentTimeMillis();
			  mergeSort(dt, 0, dt.length);
			  end = System.currentTimeMillis();
			  System.out.println("MergeSort Cost: " + (end - start));

		    //==========================================================
		    //Benchmarking Arrays.sort
			  for(int j = 0; j < N; j++) dt[j] = (int)(Math.random()*N);
			  start = System.currentTimeMillis();
			  Arrays.sort(dt);
			  end = System.currentTimeMillis();
			  System.out.println("Arrays.Sort Cost: " + (end - start));

		    //==========================================================
			  
			  
  /*=======================================================================================
   *  Benchmarking Report for each of the sorting algorithms
   =========================================================================================
   *   MergeSort
   *  What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =1000000
   data randomly generated based on N
   Cost MergeSort : 228
   

   Repeated K times: average costs
   Comparative analysis based on data
   *  =======================================================================================
   *   QuickSort
   * What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =1000000
   data randomly generated based on N
   Cost QuickSort : 151
   

   Repeated K times: average costs
   Comparative analysis based on data
   *
   *
   * ========================================================================================
   *  Arrays.sort
   * What type of CPU: Intel core i5
  Amount of Memory: 4 GB
  Speed of processor: 2.5GHz
   Test1
   Data size: N =1000000
   data randomly generated based on N
   Cost Arrays.Sort : 173
   

   Repeated K times: average costs
   Comparative analysis based on data
   *
   *
   * ========================================================================================
   *  Comparison based on your test results
   * 
   *	Quicksort is much faster based on random numbers.
   *
   */ 
   //=====================================================================================
  }
  

  static void quickSort(int f[], int p, int q){
		  if(q-p <= 1)
		      ; //skip
		  else{
		     int x;
		     int i, j, k;
		     // let x = middle element in f[p..q-1]
		     x = f[(p+q)/2];
		     //x = f[p];
		     i = p; j = p; k = q;
		     while(j != k){
		       if(f[j] == x)
		          j = j + 1;
		       else if(f[j] < x){ //swap f[j] with f[i]
		          int temp;
		          temp = f[j];
		          f[j] = f[i];
		          f[i] = temp;
		          j = j + 1;
		          i = i + 1;
		       }
		       else{ // f[j] > x
		          // swap f[j] with f[k-1]
		          int temp;
		          temp = f[j];
		          f[j] = f[k-1];
		          f[k-1] = temp;
		          k = k - 1;
		       }
		     }
         quickSort(f,p,i);
         quickSort(f,j,q);
		  }
    }

    static void mergeSort(int f[], int lb, int ub){
    	//termination reached when a segment of size 1 reached - lb+1 = ub
    	if(lb+1 < ub){
    		int mid = (lb+ub)/2;
    		mergeSort(f,lb,mid);
    		mergeSort(f,mid,ub);
    		merge(f,lb,mid,ub);
    	}
    }
    static void merge(int f[], int p, int q, int r){
    	//p<=q<=r
    	int i = p; int j = q;
    	//use temp array to store merged sub-sequence
    	int temp[] = new int[r-p]; int t = 0;
    	while(i < q && j < r){
    		if(f[i] <= f[j]){
    			temp[t]=f[i];i++;t++;
    		}
    		else{
    			temp[t] = f[j]; j++; t++;
    		}
    	}
    	//tag on remaining sequence
    	while(i < q){
    		temp[t]=f[i];i++;t++;
    	}
    	while(j < r){
    		temp[t] = f[j]; j++; t++;
    	}
    	//copy temp back to f
    	i = p; t = 0;
    	while(t < temp.length){
    		f[i] = temp[t];
    		i++; t++;
    	}
    }
}