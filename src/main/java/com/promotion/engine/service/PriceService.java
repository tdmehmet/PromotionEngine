package com.promotion.engine.service;


import java.util.List;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.ProductItem;
import com.promotion.engine.model.Promotion;
import com.promotion.engine.repository.IPromotionRepository;

public class PriceService implements IPriceService{

	IPromotionRepository promotionRepository;
	
	
	
	public PriceService(IPromotionRepository promotionRepository) {
		this.promotionRepository = promotionRepository;
	}

	/**
	 * 
	 * @param cart
	 * @param promotionList
	 * @return total price of the cart with promotions
	 */

	@Override
	public double calculatePromotedTotalPrice(Cart cart) {
		// Calculation of total promotion price.
		double totalPromotionPrice = applyPromotions(cart);
		double totalRemainingProductPrice = 0;
		// Calculation of remaining items
		for (ProductItem productItem: cart.getcartProductItemList()) {
			totalRemainingProductPrice += productItem.getProduct().getDiscountedPrice() * productItem.getQuantity();
		}
		// returns total cart price calculated by adding total promotion price with total remaining product price.
		return totalPromotionPrice + totalRemainingProductPrice;
	}
	
	/**
	 * 
	 * @param cart
	 * @param promotionList
	 * @return total promotion price
	 * 
	 * for each promotion calculates promotion prices of cart items.
	 * 
	 */
	private double applyPromotions(Cart cart)
    {
     	double totalPromotionPrice = 0;
     	List<Promotion> promotionList = this.promotionRepository.getPromotionList();
    	for(Promotion promotion : promotionList ) {
    		// POLYMORPHISM ---
    		IPromotionService promotionService = promotion.isComboPromotion() ? new ComboPromotionService() : new NonComboPromotionService();
    		totalPromotionPrice += promotionService.calculatePromotionPrice(cart, promotion);
    	}
    	
    	return totalPromotionPrice;
    }

}
