package impl;

import java.util.ArrayList;
import java.util.List;

/*
 * Sends a http GET request and return back the 
 * product id, name, current and original price
 */
public class Fetcher {
			
	//public static List<Double> getProduct(String productId){
	public static List<String> getProduct(String productId){
		String pageUrl = Global.ZAPPOS_API + "/Search?term=" + "\"" + productId + "\"" + "&key=" + Global.API_KEY;
		List<ProductUnit> response = Request.GET(pageUrl);		

		if(response == null)	System.out.println("Bad response from server!");			
		else{
			List<String> itemInfo = new ArrayList<>();
			if(response.size() > 0){
				itemInfo.add(response.get(0).getProductId());
				itemInfo.add(response.get(0).getProductName());
				itemInfo.add(response.get(0).getPrice().substring(1));
				itemInfo.add(response.get(0).getOriginalPrice().substring(1));
			}
			
			return itemInfo;
			
			/*List<Double> prices = new ArrayList<>();
			if(response.size() > 0){
				double price = Double.parseDouble(response.get(0).getPrice().substring(1));
				double originalPrice = Double.parseDouble(response.get(0).getOriginalPrice().substring(1));
				
				prices.add(price);
				prices.add(originalPrice);				
			}
			return prices;*/
		}
		
		return null;
	}
		
}
