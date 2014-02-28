package impl;

import java.util.List;

/*
 * This is the basic structure for getting a product information
 * using Zappose Api 
 */
class ProductUnit {	
	private String productId;
	private String productName;
	private String price;
	private String originalPrice;
    private List<ProductUnit> results;

    public String getProductId()	{	return productId;	}
    public String getProductName()	{	return productName;	}
    public String getPrice()	{	return price;	}
    public String getOriginalPrice()	{	return originalPrice;	}
    public List<ProductUnit> getResults() { return results; }               
}
