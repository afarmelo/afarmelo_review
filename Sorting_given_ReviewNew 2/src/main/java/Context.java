package main.java;
/**
 * Context.java
 * @author Adam Farmelo
 * @version 11/3/2018
 * 
 * The Context class is the user side of the Strategy pattern. Through
 * the context class you can acess any sort method you want, with only 
 * an integer choice.
 *
 */
import java.util.HashMap;


/**
 * Context provides a collection of SortMethods, and a map of strings
 * for the end user to determine which sort method he'd like to use
 * without any ugly switch statements or logical conditions.
 */
public class Context {

	/**
	 * Create a context object
	 * @param choice a choice of sort method
	 */
	public Context(int choice) {
		init();
		
        this.choice = choice;
        
		this.sorter = sorters[choice];
	}
	
	/**
	 * Call the sort method that is encapsulated in this class
	 * which has been previously chosen on object creation
	 * @param vec the vector to sort
	 */
	public void executeSort(Item[] vec) {
		sorter.sort(vec);
	}
	
	/**
	 * Get your choice of sorting algorithm as a string
	 * @return the string representation of the sort algorithm
	 */
	public String getSortChoice() {
		if (choice == -1) {
			throw new InvalidOperationException("No sorter chosen");
		}
		return choiceMap.get(choice);
	}
	
	private void init() {
        choiceMap.put(0, "Bubble Sort");
        choiceMap.put(1, "Selection Sort");
        choiceMap.put(2, "Insertion Sort");
        choiceMap.put(3, "Merge Sort");
        choiceMap.put(4, "Quick Sort");
        choiceMap.put(5, "Heap Sort");  
        
        sorters = new SortMethod[6];
        sorters[0] = new BubbleSort();
        sorters[1] = new SelectionSort();
        sorters[2] = new InsertionSort();
        sorters[3] = new MergeSort();
        sorters[4] = new QuickSort();
        sorters[5] = new HeapSort();
	}
	
	private SortMethod sorter;
	private SortMethod[] sorters;
	private int choice = -1;
    private HashMap<Integer, String> choiceMap = new HashMap<Integer, String>();
}
