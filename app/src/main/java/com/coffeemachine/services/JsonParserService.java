package com.coffeemachine.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.coffeemachine.models.Beverage;
import com.coffeemachine.models.Item;

/**
 * This is the service class for the JSON parsing. It parses the json in the
 * intended format only. Else it will throw error.
 * 
 * @author pritampallab
 *
 */
public class JsonParserService {
	private List<Item> inventoryItems;
	private List<Beverage> beverages;
	private int outletsCount;

	@SuppressWarnings("unchecked")
	public JsonParserService(String fileName) throws JSONException, IOException {
		this.beverages = new ArrayList<Beverage>();
		JSONObject machine = new JSONObject(FileUtils.readFileToString(
				new File(getClass().getClassLoader().getResource(fileName).getFile()), StandardCharsets.UTF_8))
						.getJSONObject("machine");
		this.outletsCount = machine.getJSONObject("outlets").getInt("count_n");
		Map<String, Object> totalItemsQuantity = machine.getJSONObject("total_items_quantity").toMap();
		inventoryItems = populateItemList(totalItemsQuantity);
		Map<String, Object> beverages = machine.getJSONObject("beverages").toMap();
		for (String name : beverages.keySet()) {
			Map<String, Object> beverageIngredients = (Map<String, Object>) beverages.get(name);
			this.beverages.add(populateBeverage(name, beverageIngredients));
		}
	}

	/**
	 * This method returns the list of inventory items
	 * 
	 * @return List<Item>
	 */
	public List<Item> getInventoryItems() {
		return inventoryItems;
	}

	/**
	 * This method returns the list of parsed beverages
	 * 
	 * @return
	 */
	public List<Beverage> getBeverages() {
		return beverages;
	}

	/**
	 * This method returns the number of outlets
	 * 
	 * @return
	 */
	public int getOutletsCount() {
		return outletsCount;
	}

	/**
	 * This method populates the beverages
	 * 
	 * @param name                   String
	 * @param beverageIngredientsMap Map<String, Object>
	 * @return Beverage
	 */
	private Beverage populateBeverage(String name, Map<String, Object> beverageIngredientsMap) {
		Beverage beverage = new Beverage();
		beverage.setName(name);
		beverage.setIngredients(populateItemList(beverageIngredientsMap));
		return beverage;
	}

	/**
	 * This method populates the items
	 * 
	 * @param totalItemsQuantity
	 * @return
	 */
	private List<Item> populateItemList(Map<String, Object> totalItemsQuantity) {
		List<Item> items = new ArrayList<Item>();
		for (String itemName : totalItemsQuantity.keySet()) {
			items.add(new Item(itemName, (Integer) totalItemsQuantity.get(itemName)));
		}
		return items;
	}

}
