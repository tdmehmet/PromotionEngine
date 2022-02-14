package com.promotion.engine.service;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.ProductItem;
import com.promotion.engine.model.Promotion;

public class ComboPromotionService implements IPromotionService{


	@Override
	public double calculatePromotionPrice(Cart cart, Promotion promotion) {
		int numPromstoApply = 0;
		// There are more than 1 different products in promotion Product Item list
		for(ProductItem promotionProductItem : promotion.getPromotionProductItemList()) {
			// for each promotion product item get the quantity
			int promotionQuantity = promotionProductItem.getQuantity();
			ProductItem searchItem = cart.findItem(promotionProductItem);
			
			if(searchItem == null) {
				return 0;
			}
			int cartQuantity = searchItem.getQuantity();
			// number of promotions to apply may be greater than 1 and maybe number of promotion quantity be different for each
			// item.
			if(cartQuantity / promotionQuantity < numPromstoApply || numPromstoApply == 0) {
				numPromstoApply = cartQuantity / promotionQuantity;
			}
		}
		// removing the items that were part of promotion
		// this removing priocess is because all promotions are mutually exclusive!...
		for (ProductItem promotionProductItem : promotion.getPromotionProductItemList()) {
			ProductItem searchItem = cart.findItem(promotionProductItem);
			if(searchItem != null) {
				searchItem.setQuantity(searchItem.getQuantity() - numPromstoApply * promotionProductItem.getQuantity());
			}
		}
		return numPromstoApply * promotion.getPromotionPrice();
	}

}
