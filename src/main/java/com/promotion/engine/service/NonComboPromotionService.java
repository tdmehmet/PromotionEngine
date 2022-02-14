package com.promotion.engine.service;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.ProductItem;
import com.promotion.engine.model.Promotion;

public class NonComboPromotionService implements IPromotionService{
	
	@Override
	public double calculatePromotionPrice(Cart cart, Promotion promotion) {
		
		return 0;
	}

}
