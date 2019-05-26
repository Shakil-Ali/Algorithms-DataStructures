// Import java utils module
import java.util.*;

// class hashtable
public class HashTable {
    // public for testing purposes
    public int buckets[];

    // Instance Variables for Hash Table Constructor
    private long a;
    private long c;
    private long m;

    // constructor hashtable
    public HashTable(long _a, long _c, long _m) {
        this.a = _a;
        this.c = _c;
        this.m = _m;
        // buckets now equals a new bucket with the size m
        buckets = new int [(int) this.m];
    }

    // hash function, takes argument key
    public int hash(int key) {
        // hashing formula
        int key_hash = (int) ((this.a*key + this.c) % this.m);
        return key_hash;
    }

    // insert function
    public void insert(int key) {
        // make i get hashed
        int i = hash(key);
        // the element being interrogated is k
        int k = 0;
        // variable j will be probing using i and k, and checking with the size of buckets (m)
        int j = probe(i, k, (int) m);
        // while buckets (probed) is not empty
        while(buckets[j] != 0)
        {
            // probe again
            j = probe(i, k, (int) m);
            // increment k by one, so new element being probed in buckets
            k += 1;
            // check if the new value at k is greater than the size of buckets (m)
            if(k > m)
            {
                // call the extend function
                extend();
                // set interrogation value to start of the buckets 
                k = 0;
                // hash the value and set it to the variable i
                i = hash(key);
            }
        } 
        // set the probed value of buckets to the key
        buckets[j] = key;
    }
    
    // functiom for find
    public boolean find(int key) {
        // same as insert
        int i = hash(key);
        int k = 0;
        int j = probe(i, k, (int) m);
        //  while interrogation value less than size of m
        while(k < m)
        {
            // increment k byb 1
            k += 1;
            // probe
            j = probe(i, k, (int) m);
            // check if the value being probed in buckets is equal to thr key
            if (buckets[j] == key)
            {
                // return true statement
                return true;
            }
        }
        // return false statement
        return false;
    }

    // function for load factor 
    public double loadFactor() {
        // set a variable for the average of the bucket
        int avg_bucket = 0;
        // for loop to iterate through the buckets array
        for(int i = 0; i < buckets.length; i++)
        {
            // check if it is not empty at index i
            if(!isEmpty(i))
            {
                // increment the avg_bucket
                avg_bucket += 1;
            }
        }
        // return the value when avg_bucket is divided by the length og buckets (m)
        return (double) avg_bucket/ (double) m;
    }

    // probe function
    public int probe(int i, int k, int h) {
        // return the modulo of the sum of i and k by the length of buckets (m)
        return ((i+k) % (int) m);
    }

    // isempty function
    public boolean isEmpty(long j) {
        // turn long j into integer j
        int temp_j = (int) j;
        // if the tempy_j index in buckets is equal to 0, return true
        if(buckets[temp_j] == 0)
        {
            // return true statement
            return true;
        }
        // return false statement
        return false;
    }

    // remove function
    public void remove(int key) {
        // same as insert
        int i = hash(key);
        int k = 0;
        int j = probe(i, k, (int) m);
        // while index j of buckers is not the key
        while(buckets[j] != key)
        {
            // set j to probe
            j = probe(i, k, (int) m);
        }
        // buckers index j is set to the tombstone value (-69 is my special character)
        buckets[j] = -69;
    }

    // free function
    public boolean free(int value) {
        // return statement for if empty or free
        return ((isEmpty((long) value)) || (value == -69));
    }

    // extend function
    public void extend() {
        // save_array ineteger array
        int [] save_array = buckets;
        // new bucket made, with extension (m multiplied by 69)
        buckets = new int [(int) this.m * 69];
        // m is now multiplied by 69
        m = m * 69;
        // for loop tp iterate through save_array array
        for(int i = 0; i < save_array.length; i++)
        {
            // call insert function, to store index i of save_array, in correct position
            insert(save_array[i]);
        }
    }


}
