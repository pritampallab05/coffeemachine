package com.coffeemachine.models;

/**
 * This is item class DAO
 * 
 * @author pritampallab
 *
 */
public class Item {

	// This is the name of the item
	private String name;

	// This is the quantity of the item
	private int quantity;

	public Item(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	/**
	 * Returns the name of the item
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the item
	 * 
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the quantity of the item
	 * 
	 * @return int
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the item
	 * 
	 * @param quantity int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
