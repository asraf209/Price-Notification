package impl;

import java.net.URL;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

/*
 * Does the http GET request and returns back the JSON response which is then parsed
 * to extract the useful information
 */
class Request {
		
	static List<ProductUnit> GET(String pageUrl){
		URL url;		
		try {
			url = new URL(pageUrl);
			InputStream inputStream = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		    String response = reader.readLine();		    		    		    		    
		    //System.out.println(response);
		    
		    ProductUnit productJSON = new Gson().fromJson(response, ProductUnit.class);		    
		    List<ProductUnit> product = productJSON.getProduct();
		    
		    return product;		    
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}		
		return null;
	}
}
