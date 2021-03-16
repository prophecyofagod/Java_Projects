/*
    Mario Saiz
    Lab 11
    3/31/19
*/

package csc2403s19lab11;

public class SimpleHashTable {
    private int collisions = 0;
    private int entries = 0;
    private HashObject h;
    public int getCollisions() { return collisions; }
    private final int tableSize = 23;
    private String[] table;
    public SimpleHashTable(HashObject a) {
        table = new String[tableSize];
        h = a;
    }
    public String toString() { String retval = "";
        for(String s: table) retval += s+", ";
        return retval;
    }
    public Boolean isEmpty() { return entries == 0; }
    void put(String entry) {
        int hashval = (h.hashFunction(entry) % tableSize);
        // avoid problems with negative values
        hashval = (hashval + tableSize) % tableSize;
        if (table[hashval]!=null) collisions++;
        while(table[hashval] != null) {
            hashval = (hashval + 1)% tableSize;
        }
        table[hashval] = entry;
        entries++;
        return;
    }
}
