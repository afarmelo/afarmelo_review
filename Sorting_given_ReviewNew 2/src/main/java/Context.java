package main.java;

import java.util.HashMap;

public class Context {

	public Context(int choice) {
		init();
		
        this.choice = choice;
        
		this.sorter = sorters[choice];
	}
	
	public void executeSort(Item[] vec) {
		sorter.sort(vec);
	}
	
	public String getSortChoice() {
		if (choice == -1) {
			throw new InvalidOperationException("No sorter chosen");
		}
		return choiceMap.get(choice);
	}
	
	private void init() {
        choiceMap.put(0, "BubbleSort");
        choiceMap.put(1, "Selection Sort");
        choiceMap.put(2, "Insertion Sort");
        choiceMap.put(3, "Merge Sort");
        choiceMap.put(4, "Quick Sort");
        choiceMap.put(5, "Bubble Sort");  
        
        sorters = new SortMethod[6];
        sorters[0] = new BubbleSort();
        sorters[1] = new SelectionSort();
        sorters[2] = new InsertionSort();
        sorters[3] = new MergeSort();
        sorters[4] = new QuickSort();
        sorters[5] = new BubbleSort();
	}
	
	private SortMethod sorter;
	private SortMethod[] sorters;
	private int choice = -1;
    private HashMap<Integer, String> choiceMap = new HashMap<Integer, String>();
}
