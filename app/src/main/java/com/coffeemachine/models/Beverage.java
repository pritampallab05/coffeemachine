package com.coffeemachine.models;

import java.util.List;

/**
 * This is the beverage model
 * 
 * In real time application this should be the data access object (DAO) for
 * storing the data
 * 
 * @author pritampallab
 *
 */
public class Beverage {
	// The name of the beverage
	private String name;

	// The list of the ingredients required
	private List<Item> ingredients;

	/**
	 * Returns the beverage name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the beverage name
	 * 
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the list of ingredients
	 * 
	 * @return List<Item>
	 */
	public List<Item> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets the list of ingredients
	 * 
	 * @param ingredients List<Item>
	 */
	public void setIngredients(List<Item> ingredients) {
		this.ingredients = ingredients;
	}

}
