/*
 * This class is model used for both Promotion and cart classes
 * Each promotion has a product item list that includes number of products to be 
 * carted to have the right to get promotion. 
 * 
 * cart class has a list of ProductItem because each cart has more than 1 type 
 * of products with their quantities.
 *  
 */
package com.promotion.engine.model;

public class ProductItem {
	
	private  Product product;
	private int quantity;
	
	/**
	 * 
	 * @param product
	 * @param quantity
	 * 
	 * Constructor for product items
	 */
	public ProductItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;

	}
	
	/**
	 * 
	 * Getter and setter methods
	 */
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
