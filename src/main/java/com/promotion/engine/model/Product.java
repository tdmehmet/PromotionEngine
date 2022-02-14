package com.promotion.engine.model;

public class Product {
	
	/**
	 * Stock Keeping Unit
	 */
	private String sku;
	/**
	 * Unit price of the product
	 */
	private double unitPrice;
	/**
	 * Discount to be applied to product.
	 * Not asked in the sample test cases but mentioned to be used in the future.
	 */
	private double discount;
	
	
	/**
	 * 
	 * @param sku
	 * @param unitPrice
	 * @param discount
	 * 
	 * Constructor for Product Object
	 * 
	 */
	public Product(String sku, double unitPrice, double discount) {
		this.sku = sku;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}

	
	/**
	 * 
	 * Getter and setter methods for each private Class fields
	 * 
	 */
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscountedPrice() {
		return unitPrice * (1 - discount/100);
	}
	
	
	/**
	 * Override of default equals method of Object class
	 * 
	 * Method is overridden because I would just like to compare sku fields of product
	 * for equality of 2 objects while comparing promotion products with cart products.
	 * 
	 */
	@Override
	public boolean equals(Object product) {
		return this.sku.equals(((Product)product).sku);
	}

}
