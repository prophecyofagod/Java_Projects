/*
    Mario Saiz
    Lab 11
    3/31/19
*/

package csc2403s19lab11;


public class HashObjectLastTwo extends HashObject {
    @Override
    public int hashFunction(String s) {
       int sum = 0;
       sum = s.charAt(s.length()-1) + s.charAt(s.length()-2);
       return sum;
    }
}
