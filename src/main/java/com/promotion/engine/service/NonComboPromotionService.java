package com.promotion.engine.service;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.ProductItem;
import com.promotion.engine.model.Promotion;

public class NonComboPromotionService implements IPromotionService{
	
	@Override
	public double calculatePromotionPrice(Cart cart, Promotion promotion) {
		
		int numPromstoApply = 0;
		
		// If not a combo offer there will be only one product item in promotion product item list.
		// that is why I got the 0 indexed item from the list.
		ProductItem promotionProductItem = promotion.getPromotionProductItemList().get(0);
		// how many of that item should be carted to have the promotion
		int promotionQuantity = promotionProductItem.getQuantity();
		// find how many of the item is carted
		ProductItem searchItem = cart.findItem(promotionProductItem);
		if(searchItem != null) {
			// if Item carted then get the cart quantity.
			int cartQuantity = searchItem.getQuantity();
			// when I divide cart quantity by romotion quantity i get the number of promotions to be applied
			numPromstoApply = cartQuantity / promotionQuantity;
			// when I get the modulus of cart quantity over promotion quantity I get the number of remaining items.
			// This removal process is because all promotions are mutually exclusive!...
			int remainingItems = cartQuantity % promotionQuantity;
			// reset the remaining items to cart again to calculate their price without offer
			searchItem.setQuantity(remainingItems);
		}
		return numPromstoApply * promotion.getPromotionPrice();
	}

}
