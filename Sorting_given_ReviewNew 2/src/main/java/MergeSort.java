package main.java;
/**
 * MergeSort.java
 * @author Adam Farmelo
 * @version 11/3/2018
 * 
 * MergeSort is a concrete class which implements SortMethod.java
 */

/**
 * MergeSort uses the traditional merge sort algorithm to sort
 * an array of Items.
 */
public class MergeSort implements SortMethod {

    /**
     * Sorts with merge sort algorithm
     * @param vec the array to be sorted
     * @throws NullPointerException if <code>vec</code> 
     * is not initialized
     */
	@Override
	public void sort(Item[] vec) throws NullPointerException {
		if (vec == null) {
			throw new NullPointerException();
		}
        mergeSort(vec, 0, vec.length - 1);
	}
	
    /**
     * sorts array by mergesort in a certain range
     * @param vec the array in which this happens
     * @param first start of the range
     * @param last end of the range
     */
    private static void mergeSort(Item[] vec, int first, int last) {
        if (first == last) {
        	return;	
        }
        // divide vec into 2 equal parts
        int middle = (first + last) / 2; 
        mergeSort(vec, first, middle);   // sort the first part
        mergeSort(vec, middle+1, last);  // sort the second part
        merge(vec, first, middle, last); // merge the 2 sorted parts
    }
    
	/**
     * merges two sorted adjacent ranges of an array
     * @param vec the array in which this happens
     * @param left start of the first range
     * @param middle end of the first range
     * @param right end of the second range
     */
    private static void merge(Item[] vec, int left, int middle, int right) {
        int i, j;
        int m = middle - left + 1; // length of first array region
        int n = right - middle;    // length of second array region
    
        // make copies of array regions to be merged 
        // (only the references to the items)
        Item[] copy1 = new Item[m];
        Item[] copy2 = new Item[n];
        for (i = 0; i < m; i++) {
        	copy1[i] = vec[left + i]; 
        }
        for (j = 0; j < n; j++) {
        	copy2[j] = vec[middle + 1 + j]; 
        }
            
        i = 0; j = 0;   
        // merge copy1 and copy2 into  vec[left...right]
        while (i < m && j < n) {
            if (copy1[i].key < copy2[j].key) {
                    vec[left+i+j] = copy1[i];
                    i++;
            } else {
                    vec[left+i+j] = copy2[j];
                    j++;
            }//endif
        }//endwhile
        if (j == n) { // second array region is completely handled, 
            // so copy rest of first region
            while (i < m) {
                vec[left+i+j] = copy1[i];
                i++;
            }
        }
        // if (i == m) do nothing, 
        // rest of second region is already in place
    }

}
