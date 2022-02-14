package com.promotion.engine.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.promotion.engine.model.Product;
import com.promotion.engine.model.ProductItem;
import com.promotion.engine.model.Promotion;

public class PromotionRepository implements IPromotionRepository{
	
	public List<Promotion> getPromotionList() {
		List<Promotion >promotionList = new ArrayList<Promotion>();
		
		promotionList.add(new Promotion(Arrays.asList(new ProductItem(new Product("A", 50, 0), 3)), 130, false, 1));
		promotionList.add(new Promotion(Arrays.asList(new ProductItem(new Product("B", 50, 0), 2)), 45, false, 2));
		promotionList.add(new Promotion(Arrays.asList(
				new ProductItem(new Product("C", 20, 0), 1), 
				new ProductItem(new Product("D", 15, 0), 1)), 30, true, 3));
		
		return promotionList;
	}
}
