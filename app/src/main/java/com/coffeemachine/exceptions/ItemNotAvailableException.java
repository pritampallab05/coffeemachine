package com.coffeemachine.exceptions;

import com.coffeemachine.models.Item;

/**
 * This is the item not available exception handler
 * 
 * @author pritampallab
 *
 */
public class ItemNotAvailableException extends Exception {
	private static final long serialVersionUID = 7639511818098587188L;
	private static String EXCEPTION_MESSAGE = "%s is not available";

	public ItemNotAvailableException(Item item) {
		super(String.format(EXCEPTION_MESSAGE, item.getName()));
	}
}
