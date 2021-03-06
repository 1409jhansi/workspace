package com.market;

import java.util.Map;

/**
 * The SupermarketRegister program implements a checkout register application
 * that calculates the price of a given sequence of items
 *
 * @author Ashish Sharma
 * @version 1.0
 * @since 2015-02-03
 */
public class SupermarketRegister implements Supermarket {

	/**
	 * This method is used to provide items and returned the sum of those items price.
	 * 
	 * @param items This is the only paramter to checkout method which contains items
	 * @return int This returns sum provide items price
	 */
	public int checkout(String items) {

		DataWarehouse dataWarehouse = new DataWarehouse();
		Map<String, Integer> productInfo = dataWarehouse.getProduct();
		int totalPrice = 0;

		char[] itemsArray = items.toCharArray();
		for (char item : itemsArray) {
			Integer itemPrice = productInfo.get(String.valueOf(item));
			if (itemPrice != null) {
				totalPrice += itemPrice;
			} else {
				System.out.println("Item: " + item+ " not found in DataWarehouse");
			}
		}
		return totalPrice;
	}

}
