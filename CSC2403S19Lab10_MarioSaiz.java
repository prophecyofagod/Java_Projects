/*
    Mario Saiz
    Lab 10
    3/25/19
*/

package csc2403s19lab10;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class CSC2403S19Lab10 {

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
            result.add(rand.nextInt(100000));
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
     * @param l an ArrayList of integers
     * This sorts l using a heap Sort
     */        
    public static void heapSort(ArrayList<Integer> l)
    {
        Heap<Integer> myHeap = new Heap();
        
        int n = l.size();
        int i = 0; 
        
        
     while(i<n){
        Integer x = l.get(i);
        myHeap.add(x);
        i++;
     }
     
     i = 0;
        while(i<n){
            Integer y = myHeap.remove();
            l.set(i, y);
            i++;
    }
   }
    
     /**
     * @param args the command line arguments
     */   
    public static void main(String[] args) {
        // Here we are creating 4 separate ArrayLists
        // all containing the same random numbers.
        
        ArrayList<Integer> myList1;
        myList1 = randomList(80000);
        ArrayList<Integer> myList2 = (ArrayList<Integer>) myList1.clone();
        ArrayList<Integer> myList3 = (ArrayList<Integer>) myList1.clone();
        ArrayList<Integer> myList4 = (ArrayList<Integer>) myList1.clone();
        
        

     
        
        long startTime1 = System.nanoTime();
        heapSort(myList1);
        long endTime1 = System.nanoTime();
        long elapsed1 = endTime1 - startTime1;
        System.out.println("Heap-Sort took:" + elapsed1 + " nanoseconds" + "\n");
        
         
        
        long startTime2 = System.nanoTime();
        bubbleSort(myList2);
        long endTime2 = System.nanoTime();
        long elapsed2 = endTime2 - startTime2;
        System.out.println("Bubble-Sort took:" + elapsed2 + " nanoseconds" + "\n");
        
 
        
        long startTime3 = System.nanoTime();
        insertionSort(myList3);
        long endTime3 = System.nanoTime();
        long elapsed3 = endTime3 - startTime3;
        System.out.println("Insertion-Sort took:" + elapsed3 + " nanoseconds" + "\n");
        
  
        
        long startTime4 = System.nanoTime();
        Containers.sort(myList4);
        long endTime4 = System.nanoTime();
        long elapsed4 = endTime4 - startTime4;
        System.out.println("Container-Sort took:" + elapsed4 + " nanoseconds" + "\n");
    }

}
