/*
    Mario Saiz
    Lab 11
    3/31/19
*/

package csc2403s19lab11;

public class HashObjectPoly extends HashObject {
    @Override
    public int hashFunction(String s) {
       int sum = 0;
       int n = 0;
       for(int i = 0; i<s.length(); i++){
            n++;
            sum += s.charAt(i)*n;
       }
       return sum;
    }
}
