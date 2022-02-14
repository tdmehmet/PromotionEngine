/*
 * This class is the model of cart. It has just Product Item List. 
 * I did not directly products because in the next steps I would like 
 * to calculate cart price according to promotions. That is why would like
 * to have quantity of each Item carted.
 * 
 * Added a method to get cart price without promotion in case of any required comparision 
 * between the promotion cost and without promotion cost.
 * 
 */


package com.promotion.engine.model;


import java.util.List;


public class Cart {
	
	/**
	 * List of product item which has both product as an object and 
	 * product' s quantity.
	 */
	private List<ProductItem> cartProductItemList;

	/**
	 * 
	 * @param cartProductItemList
	 * 
	 * Constructor for creation of cart Object.
	 */
	public Cart(List<ProductItem> cartProductItemList) {
		this.cartProductItemList = cartProductItemList;
	}

	/**
	 * 
	 *Getter and setter methods for private field cartProductItemList.
	 *
	 */
	public List<ProductItem> getcartProductItemList() {
		return cartProductItemList;
	}

	public void setcartProductItemList(List<ProductItem> cartProductItemList) {
		this.cartProductItemList = cartProductItemList;
	}
	
	/**
	 * 
	 * @return double total price without promotion
	 * 
	 * Calculates cart price without promotion.
	 * 
	 */
	public double getcartPriceWithoutPromotion() {
		
		double actualCost = 0.0;
		
		for (ProductItem item : cartProductItemList) {
			actualCost += item.getProduct().getDiscountedPrice() * item.getQuantity();
		}
		
		return actualCost;
	}
	/**
	 * 
	 * @param productItem
	 * @return productItem
	 * 
	 * Finds matching product item according to given product item parameter.
	 * 
	 */
	public ProductItem findItem(ProductItem productItem) {
		for(ProductItem cartProductItem : this.cartProductItemList) {
			if(productItem.getProduct().equals(cartProductItem.getProduct())) {
				return cartProductItem;
				
			}
		}
		return null;
	}
	
}
