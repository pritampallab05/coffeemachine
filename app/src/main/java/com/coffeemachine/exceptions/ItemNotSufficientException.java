package com.coffeemachine.exceptions;

import com.coffeemachine.models.Item;

/**
 * This is the item not sufficient exception handler
 * 
 * @author pritampallab
 *
 */
public class ItemNotSufficientException extends Exception {
	private static final long serialVersionUID = 7746861294332442673L;
	private static String EXCEPTION_MESSAGE = "%s is not sufficient";

	public ItemNotSufficientException(Item item) {
		super(String.format(EXCEPTION_MESSAGE, item.getName()));
	}
}
