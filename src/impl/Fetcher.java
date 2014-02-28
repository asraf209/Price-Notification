package impl;

import java.util.ArrayList;
import java.util.List;

/*
 * Sends a http GET request and return back the 
 * product id, name, current and original price
 * as a list
 */
public class Fetcher {
				
	public static List<String> getProduct(String productId){
		
		String pageUrl = Global.ZAPPOS_API + "/Product?id=" + "[" + "\"" + productId + "\"" + "]" + "&includes=[\"styles\"]" + "&key=" + Global.API_KEY;		
		List<ProductUnit> product = Request.GET(pageUrl);		
		
		if(product == null)		System.out.println("Bad response from server!");			
		else{
			List<String> itemInfo = new ArrayList<>();
			if(product.size() > 0){
				itemInfo.add(product.get(0).getProductId());
				itemInfo.add(product.get(0).getProductName());
				itemInfo.add(product.get(0).getStyles().get(0).getPrice().substring(1));
				itemInfo.add(product.get(0).getStyles().get(0).getOriginalPrice().substring(1));
			}
			
			return itemInfo;
						
		}
		
		return null;
	}
		
}
