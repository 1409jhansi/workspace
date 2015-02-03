package com.market;

/**
 * The Supermarket program implements a checkout register application
 * that calculates the price of a given sequence of items
 *
 * @author Ashish Sharma
 * @version 1.0
 * @since 2015-02-03
 */

public interface Supermarket {
	/**
	 * This method is used to provide items and returned the sum of those items price.
	 * 
	 * @param items This is the only paramter to checkout method which contains items
	 * @return int This returns sum provide items price
	 */
	public int checkout(String items);

}
