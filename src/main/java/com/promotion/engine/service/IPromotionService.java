package com.promotion.engine.service;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.Promotion;

public interface IPromotionService {
	public double calculatePromotionPrice(Cart cart, Promotion promotion);
}
