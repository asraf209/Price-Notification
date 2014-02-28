package impl;

import java.util.List;

/*
 * This is the basic structure for getting a product information
 * using Zappose Api 
 */
class ProductUnit {	
	private String productId;
	private String productName;	
	private List<StyleUnit> styles;    
	private List<ProductUnit> product;

    public String getProductId()	{	return productId;	}
    public String getProductName()	{	return productName;	}    
    public List<StyleUnit> getStyles() { return styles; }
    public List<ProductUnit> getProduct() { return product; }
}
