/**
 * This promotion class is used for applying each promotions to carts.
 * It encapsulates promotion application rules inside itself so that promotion manager
 * will only use this class to calculate promoted prices.
 * 
 * It has promotionProductItemList --> gives promotion product and quantity to be carted to activate promotion.
 * There can be more than 1 SKUs in just one promotion as in the example C & D.
 * 
 * Offer Price --> means the promotion price for example if you buy 3 A, offer price would be 130 instead of 150
 * comboOffer --> to identify if the offer has more than one SKUs
 * priority --> this field is used to cart application of Promotions to any cart
 * 
 */
package com.promotion.engine.model;

import java.util.List;

public class Promotion {
	
	/**
	 * Class fields
	 */
	private List<ProductItem> promotionProductItemList;
	private double promotionPrice;
	private boolean comboPromotion;
	private int priority;
	
	
	/**
	 * 
	 * @param promotionProductItemList
	 * @param offerPrice
	 * @param comboOffer
	 * @param priority
	 * 
	 * Promotion Class constructor
	 * 
	 */
	public Promotion(List<ProductItem> promotionProductItemList, double promotionPrice, boolean comboPromotion,
			int priority) {
		super();
		this.promotionProductItemList = promotionProductItemList;
		this.promotionPrice = promotionPrice;
		this.comboPromotion = comboPromotion;
		this.priority = priority;
	}

	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public List<ProductItem> getPromotionProductItemList() {
		return promotionProductItemList;
	}

	public void setPromotionProductItemList(List<ProductItem> promotionProductItemList) {
		this.promotionProductItemList = promotionProductItemList;
	}

	public double getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public boolean isComboPromotion() {
		return comboPromotion;
	}

	public void setComboPromotion(boolean comboPromotion) {
		this.comboPromotion = comboPromotion;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * 
	 * Implemented to find promotion profit --> not used
	 * 
	 */
	public double getPromotionProfit() {
		
		double actualCost = 0;
		
		for (ProductItem productItem : promotionProductItemList) {
			actualCost += productItem.getProduct().getUnitPrice() * productItem.getQuantity();
		}
		
		return actualCost - promotionPrice;
		
	}
	
}
