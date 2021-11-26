package com.coffeemachine.services;

import java.util.List;

import com.coffeemachine.exceptions.ItemNotAvailableException;
import com.coffeemachine.exceptions.ItemNotSufficientException;
import com.coffeemachine.models.Beverage;
import com.coffeemachine.models.Item;

/**
 * This is the service class for beverage.
 * 
 * It implements the Runnable interface to enable multi-threading.
 * 
 * @author pritampallab
 *
 */
public class BeverageService implements Runnable {
	private InventoryService inventoryService;
	private static String MESSAGE_SUCCESSFULL_PREPARATION = "%s is prepared\n";
	private static String MESSAGE_UNSUCCESSFULL_PREPARATION = "%s cannot be prepared because %s\n";
	private Beverage beverage;

	public BeverageService(Beverage beverage) {
		this.inventoryService = new InventoryService();
		this.beverage = beverage;
	}

	/**
	 * This method prepares the beverage in a synchronized manner. So, when one
	 * thread is updating the inventory others do not tamper.
	 * 
	 * @return String
	 */
	public synchronized String prepareBeverage() {
		List<Item> beverageIngredients = beverage.getIngredients();
		for (Item ingredient : beverageIngredients) {
			try {
				inventoryService.takeItemFromInventory(ingredient);
			} catch (ItemNotAvailableException | ItemNotSufficientException e) {
				return String.format(MESSAGE_UNSUCCESSFULL_PREPARATION, beverage.getName(), e.getMessage());
			}
		}
		return String.format(MESSAGE_SUCCESSFULL_PREPARATION, beverage.getName());
	}

	@Override
	public void run() {
		System.out.println(prepareBeverage());
	}

	public Beverage getBeverage() {
		return beverage;
	}
	

}
