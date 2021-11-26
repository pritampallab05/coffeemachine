package com.coffeemachine.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main coffee machine
 * 
 * It is a singleton class considering the fact that there is a sole coffee
 * machine through out the project
 * 
 * @author pritampallab
 *
 */
public class CoffeeMachine {

	// Number of outlets available at a time for the coffee machine
	private int outletsCount;

	// List of the beverages of the coffee machine
	private List<Beverage> beverages;

	private static CoffeeMachine machine = null;

	private CoffeeMachine() {
		beverages = new ArrayList<Beverage>();
	}

	/**
	 * This returns the instance of the CoffeeMachine class
	 * 
	 * @return
	 */
	public static CoffeeMachine getCoffeeMachine() {
		if (machine == null) {
			machine = new CoffeeMachine();
		}
		return machine;
	}

	/**
	 * Returns the number of parallel outlets
	 * 
	 * @return int
	 */
	public int getOutletsCount() {
		return outletsCount;
	}

	/**
	 * Sets the outlets count
	 * 
	 * @param outletsCount int
	 */
	public void setOutletsCount(int outletsCount) {
		this.outletsCount = outletsCount;
	}

	/**
	 * Returns the list of beverages
	 * 
	 * @return List<Beverage>
	 */
	public List<Beverage> getBeverages() {
		return beverages;
	}

	/**
	 * Sets the list of Beverages
	 * 
	 * @param beverages List<Beverage>
	 */
	public void setBeverages(List<Beverage> beverages) {
		this.beverages = beverages;
	}

}
