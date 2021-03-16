/*
    Mario Saiz
    Lab 11
    3/31/19
*/

package csc2403s19lab11;


public class HashObjectSum extends HashObject {
    @Override
    public int hashFunction(String s) {
       int sum = 0;
       for(int i = 0; i<s.length(); i++){
            sum += s.charAt(i);
       }
       return sum;
    }
}
