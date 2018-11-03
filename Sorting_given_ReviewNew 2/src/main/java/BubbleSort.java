package main.java;
/**
 * BubbleSort.java
 * @author Adam Farmelo
 * @version 11/3/2018
 * 
 * BubbleSort is a concrete class which implements SortMethod.java
 */

/**
 * BubbleSort uses the traditional bubble sort algorithm to sort
 * an array of Items.
 */
public class BubbleSort implements SortMethod {

    /**
     * Sorts with bubble sort algorithm
     * 
     * Returns a NullPointerException when the array is empty
     * Returns a sorted array with the same length as the param array vec
     * 
     * @param vec the array to be sorted
     * @throws NullPointerException if <code>vec</code> 
     * is not initialized
     */
	@Override
    public void sort(Item[] vec) throws NullPointerException {
        if (vec == null) {
        	throw new NullPointerException();
        }

        int n = vec.length-1;
        Item temp;
        int bottom;       // bottom for each pass        
        for (bottom = 1; bottom < n; bottom++)  {
            for (int i = n-1; i >= bottom; i--) {
                if (vec[i-1].key > vec[i].key) {
                    temp = vec[i-1];
                    vec[i-1] = vec[i];
                    vec[i] = temp;
                }
            }
        }
    }

}
