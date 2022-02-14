package com.promotion.engine.controller;


import com.promotion.engine.model.Cart;
import com.promotion.engine.service.IPriceService;

public class PromotionEngineController {

	IPriceService priceService;
	
	public PromotionEngineController(IPriceService priceService) {
		this.priceService = priceService;
	}



	public double calculatePromotedTotalPrice(Cart cart) {
		
		return this.calculatePromotedTotalPrice(cart);
		
	}
		
	
}
