/*
    Mario Saiz
    Lab 11
    3/31/19
*/

package csc2403s19lab11;

public class HashObjectFirst extends HashObject {
    @Override
    public int hashFunction(String s) {
        return s.charAt(0);
    }
}
