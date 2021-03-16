/*
    Mario Saiz
    Lab 1
    1/26/19
*/

package csc2403s19lab1;

public class CSC2403S19Lab1 {

    /** This method should sum all the numbers between a and b.
     * If b is less than a, should return 0.
     * If b or a are less than 0 should return 0.
     * @param a - lower bound
     * @param b - upper bound
     * @return - sum of all ints between a and b
     */
    public static int sumNums(int a, int b) {
        //return 0;
        
        int i;
        int sum = 0;
    for (i = a; i <= b; i++) {
        sum += i;
    }    
        if (b < a) {
            return 0;
        }
        if (b < 0 || a < 0) {
            return 0;
        }
            return sum;
    }


    /**
     * Three input parameters are the lengths of three sides of a triangle
 You should return true if those lengths comprise a legal
 triangle, and false otherwise.See triangle rules here: https://sciencing.com/rules-length-triangle-sides-8606207.html
     * @param a - first side of triangle
     * @param b - second side of triangle
     * @param c - third side of triangle
     */
    public static Boolean isTriangle(int a, int b, int c) {
        //return false;
    
    if(a >= (b+c) || c >= (b+a) || b >= (a+c) ){
            return false;
    }
    else {
        return true;
    }
}  
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This code will test sum_nums()
        int result;
        System.out.println("Test sumNums");
        result = sumNums(1,5);
        System.out.println("Result 1: "+result);
        if (result!=15) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
        
        result = sumNums(5,1);
        System.out.println("Result 2: "+result);
        if (result!=0) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
       
        result = sumNums(3,10);
        System.out.println("Result 3: "+result);
        if (result!=52) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
        
        result = sumNums(-5,10);
        System.out.println("Result 4: "+result);
        if (result!=0) System.out.println("  ** FAIL");
        else System.out.println("  PASS");  
        
        result = sumNums(5,5);
        System.out.println("Result 5: "+result);
        if (result!=5) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
        
        System.out.println("\n\nTest isTriangle");
        Boolean bool_result;
        bool_result=isTriangle(3,4,5);
        System.out.println("Result 1: "+bool_result);
        if (bool_result!=true) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
        
        bool_result=isTriangle(2,2,4);
        System.out.println("Result 2: "+bool_result);
        if (bool_result!=false) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
        
        bool_result=isTriangle(2,7,12);
        System.out.println("Result 3: "+bool_result);
        if (bool_result!=false) System.out.println("  ** FAIL");
        else System.out.println("  PASS");  
        
        bool_result=isTriangle(7,5,4);
        System.out.println("Result 4: "+bool_result);
        if (bool_result!=true) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
        
        bool_result=isTriangle(9,3,10);
        System.out.println("Result 5: "+bool_result);
        if (bool_result!=true) System.out.println("  ** FAIL");
        else System.out.println("  PASS");
    }
    
}
