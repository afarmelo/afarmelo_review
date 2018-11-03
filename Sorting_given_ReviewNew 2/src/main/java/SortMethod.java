package main.java;

/**
 * SortMethod.java
 * @author Adam Farmelo
 * @version 11/3/2018
 * 
 * The sortMethod interface is the Strategy interface that all sorting 
 * methods will override. The inspiration from this interface comes from 
 * the Strategy design pattern. 
 * 
 * Link: https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 *
 */

/**
 * SortMethod provides the method sort(Item[] vec) which must be
 * overriden in any implementing classes. The abstraction provided
 * here allows the user to run any sort method they want at run-time, 
 * without the ugliness of a switch statement.
 */
public interface SortMethod {
	
	/*
	 * The sort method is an abstract method which will enable the 
	 * implementing methods to be called independently and gives flexibility
	 * at program runtime. 
	 * 
	 * @param vec an Item array to be sorted
	 */
	public abstract void sort(Item[] vec) throws NullPointerException;
}
