package com.promotion.engine.service;


import com.promotion.engine.model.Cart;
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
		return 0;
	}
	


}
