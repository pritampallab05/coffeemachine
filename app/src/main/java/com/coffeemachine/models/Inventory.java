package com.coffeemachine.models;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the inventory class. It is a singleton class as there is only one
 * inventory in the whole project
 * 
 * @author pritampallab
 *
 */
public class Inventory {

	// The inventory class instance
	private static Inventory inventory = null;

	// The current inventory
	private Map<String, Item> current;

	private Inventory() {
		current = new HashMap<String, Item>();
	}

	/**
	 * Returns the instance of the inventory
	 * 
	 * @return Inventory
	 */
	public static Inventory getInventory() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}

	/**
	 * Returns the current inventory
	 * 
	 * @return Map
	 */
	public Map<String, Item> getCurrent() {
		return current;
	}

	/**
	 * Sets the current inventory
	 * 
	 * @param current Map
	 */
	public void setCurrent(Map<String, Item> current) {
		this.current = current;
	}

}
