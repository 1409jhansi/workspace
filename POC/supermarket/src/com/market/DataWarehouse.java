package com.market;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The DataWarehouse program implements getting data from warehouse and returned it to upstream system
 *
 * @author Ashish Sharma
 * @version 1.0
 * @since 2015-02-03
 */

public class DataWarehouse {

	/**
	 * This method is used to get data from warehouse which is property file. It also checks price rules via PriceRuleEngine
	 * 
	 * @return Map This returns entire dataset stored in property file in form of {key,value} pair
	 * 		   key is product name and value is priceof product 	
	 */
	public Map<String,Integer> getProduct() {
		Properties prop = new Properties();
		InputStream input = null;
		Map<String,Integer> productInfo = new HashMap<String, Integer>();

		try {

			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Unable to find property file" + filename);
				return productInfo;
			}

			prop.load(input);

			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				Integer price = Integer.parseInt(value);
				
				PriceRuleEngine priceRuleEngine = new PriceRuleEngine();
				if(priceRuleEngine.applyAllRules(price)){
					productInfo.put(key,price);
				}
			}
		} catch (IOException ex) {
			System.out.println("IOException occur while reading" + ex.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("Exception occur while closing inout stream in finally" + e.getMessage());
				}
			}
		}
		return productInfo;

	}

}