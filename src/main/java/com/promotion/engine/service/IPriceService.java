package com.promotion.engine.service;

import com.promotion.engine.model.Cart;

public interface IPriceService {

	public double calculatePromotedTotalPrice(Cart cart);
	
}
