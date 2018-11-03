package main.java;
/**
 * SelectionSort.java
 * @author Adam Farmelo
 * @version 11/3/2018
 * 
 * SelectionSort is a concrete class which implements SortMethod.java
 */

/**
 * SelectionSort uses the traditional selection sort algorithm to sort
 * an array of Items.
 */
public class SelectionSort implements SortMethod {

    /**
     * Sorts with selection sort algorithm
     * @param vec the array to be sorted
     * @throws NullPointerException if <code>vec</code> 
     * is not initialized
     */
	@Override
    public void sort(Item vec[]) throws NullPointerException {
        if (vec == null) {
        	throw new NullPointerException();
        }
        
        int minIndx;            // Index of smallest key in each pass
        int bottom;             // bottom for each pass
        int i;
        Item temp;
        int n = vec.length;
    
        for (bottom = 0; bottom < n-1; bottom++) {
			//  INVARIANT (prior to test):
			//  All vec[bottom+1..n-1] are >= vec[bottom]
			//  && vec[0..bottom] are in ascending order
			//  && bottom >= 0
            minIndx = bottom;
            for (i = bottom+1; i < n; i++) {
            // INVARIANT (prior to test):
            // vec[minIndx] <= all
            // vec[0..i-1]
            // && i >= bottom+1
            if (vec[i].key < vec[minIndx].key) { 
                minIndx = i; 
            }
            }
            temp = vec[bottom];
            vec[bottom] = vec[minIndx];
            vec[minIndx] = temp; 
        }
    }

}
