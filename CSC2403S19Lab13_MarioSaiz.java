/*
    Mario Saiz
    Lab 13
    4/16/19
*/

package csc2403s19lab13;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;

public class CSC2403S19Lab13 {

    /**
     * @param size The size of the ArrayList to return.
     * 
     * This function will put size random Integers
     * between 0 and 100000 into an Array List.
     */
    public static ArrayList<Integer> randomList(int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < size; i++) {
            result.add(rand.nextInt(1000));
        }
        return result;
    }
    /**
     * @param l an ArrayList of integers
     * This sorts l using a bubbleSort
     */
    public static void bubbleSort(ArrayList<Integer> l) {
        for (int j = 0; j < l.size() - 1; j++) {
            for (int i = 0; i < l.size() - 1 -j; i++) {
                if (l.get(i) > l.get(i + 1)) {
                    Integer temp = l.get(i);
                    l.set(i, l.get(i + 1));
                    l.set(i + 1, temp);
                }

            }
        }
    }
    
     /**
     * @param l an ArrayList of integers
     * This sorts l using insertion Sort
     */
    public static void insertionSort(ArrayList<Integer> l) {
      Integer temp;
        for (int i = 1; i < l.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(l.get(j) < l.get(j-1)){
                    temp = l.get(j);
                    l.set(j,l.get(j-1));
                    l.set(j-1,temp);
                }
                else break;
            }
        }
    }
    
    /**
     * @param S
     * @param S1
     * @param S2
     * @param l an ArrayList of integers
     * This sorts l using mergeSort
     */        

    public static void merge( ArrayList<Integer> S,  ArrayList<Integer> S1,  ArrayList<Integer> S2){
        int i =0, j=0;
        while (i+j < S.size()){
            if (j == S2.size() || (i < S1.size() && (S1.get(i) < S2.get(j))))
                S.set(i+j, S1.get(i++));
            else
                S.set(i+j, S2.get(j++));
        }
    }
    
    public static void mergeSort(ArrayList<Integer> S){
      int middle;
      ArrayList<Integer> left = new ArrayList<>();
      ArrayList<Integer> right = new ArrayList<>();
      if (S.size() < 2) return;

         middle = S.size() / 2;

            for (int i = 0; i < middle; i++) 
                left.add(S.get(i));


            for (int j = middle; j < S.size(); j++)
                right.add(S.get(j));

            mergeSort(left);
            mergeSort(right);
            merge(S, left, right);
    }
   
     /**
     * @param l an ArrayList of integers
     * This sorts l using mergeSort
     */        
    public static void quickSort(ArrayList<Integer> S){
        
        quickSort(S, 0, S.size()-1);
    }
    public static void quickSort(ArrayList<Integer> S, int a, int b)
    {
        if(a >= b){
            return;
	}
	
        int left = a;
        int pivot = S.get(b);
        int right = b-1;
        int k;

		while (left <= right) {
                        while ((left <= right) && (S.get(left) < pivot)) left++;
                        while ((left <= right) && (S.get(right) > pivot)) right--;
                        if (left <= right) {
                            k = S.get(left); 
                            S.set(left, S.get(right));
                            S.set(right, k);
                            left++;
                            right--;
                        }
                }
                k = S.get(left);
                S.set(left, S.get(b));
                S.set(b, k);
		
                quickSort(S, a, left-1);
                quickSort(S, left+1, b);
      
	}
    
           
     /**
     * @param args the command line arguments
     */   
    public static void main(String[] args) {        
        
        // Here we are creating 3 separate ArrayLists
        // all containing the same random numbers.
        ArrayList<Integer> myList1;
        myList1 = randomList(50);
        ArrayList<Integer> myList2 = (ArrayList<Integer>) myList1.clone();
        ArrayList<Integer> myList3 = (ArrayList<Integer>) myList1.clone();

        insertionSort(myList1);
        System.out.println("Results of insertion sort:");
        System.out.println(myList1);
        quickSort(myList2);
        System.out.println("Results of quick sort:");
        System.out.println(myList2);
        mergeSort(myList3);
        System.out.println("Results of merge sort:");
        System.out.println(myList3);
    }

}
