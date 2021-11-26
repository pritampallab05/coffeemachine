package com.coffeemachine.services;

import java.util.List;
import java.util.Map;

import com.coffeemachine.exceptions.ItemNotAvailableException;
import com.coffeemachine.exceptions.ItemNotSufficientException;
import com.coffeemachine.models.Inventory;
import com.coffeemachine.models.Item;

/**
 * This class is the inventory service class. It handles the inventories.
 * 
 * @author pritampallab
 *
 */
public class InventoryService {
	private Inventory inventory = null;

	public InventoryService() {
		this.inventory = Inventory.getInventory();
	}

	/**
	 * This method removes items from the inventory based on availability
	 * 
	 * @param item Item
	 * @throws ItemNotAvailableException  (Item is not available)
	 * @throws ItemNotSufficientException (Item is insufficient)
	 */
	public void takeItemFromInventory(Item item) throws ItemNotAvailableException, ItemNotSufficientException {
		Map<String, Item> current = inventory.getCurrent();
		if (!current.containsKey(item.getName())) {
			throw new ItemNotAvailableException(item);
		}
		Item availableItem = current.get(item.getName());
		if (availableItem.getQuantity() < item.getQuantity()) {
			throw new ItemNotSufficientException(item);
		} else {
			availableItem.setQuantity(availableItem.getQuantity() - item.getQuantity());
		}
	}

	/**
	 * This method adds items to the inventory
	 * 
	 * @param item Item
	 */
	public void addItemToInventory(Item item) {
		Map<String, Item> current = inventory.getCurrent();
		if (!current.containsKey(item.getName())) {
			current.put(item.getName(), item);
		} else {
			Item availableItem = current.get(item.getName());
			availableItem.setQuantity(availableItem.getQuantity() + item.getQuantity());
		}
	}

	/**
	 * This method adds a list of items to the inventory
	 * 
	 * @param itemList List<Item>
	 */
	public void addItemListToInventory(List<Item> itemList) {
		for (Item item : itemList) {
			addItemToInventory(item);
		}
	}
}
