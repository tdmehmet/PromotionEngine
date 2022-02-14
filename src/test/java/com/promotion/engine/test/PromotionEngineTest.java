package com.promotion.engine.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.Product;
import com.promotion.engine.model.ProductItem;
import com.promotion.engine.model.Promotion;
import com.promotion.engine.repository.IPromotionRepository;
import com.promotion.engine.repository.PromotionRepository;
import com.promotion.engine.service.IPriceService;
import com.promotion.engine.service.PriceService;

class PromotionEngineTest {

	IPriceService priceService;
	IPromotionRepository promotionRepository;
	List<Promotion> promotionList;
	
	/**
	 * With JUNIT5 this annotation is added
	 * It runs once before each test cases
	 */
	@BeforeEach
	void beforeEach() {
		this.promotionRepository = new PromotionRepository();
		this.priceService = new PriceService(this.promotionRepository);
	}
	
	
	/**
	 * No promotion is applied......
	 */
	@Test
	void should_return_100_when_A_B_C_Ordered_Once() {
		
		// Given
		
		Cart cart = new Cart(Arrays.asList(new ProductItem(new Product("A", 50, 0), 1),
				new ProductItem(new Product("B", 30, 0), 1),
				new ProductItem(new Product("C", 20, 0), 1)
				));
		
		double expectedValue = 100;
		
		// When
		
		double actualValue = this.priceService.calculatePromotedTotalPrice(cart);
		
		// Then
		
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	void should_return_370_when_5A_5B_1C_Ordered() {
		
		// Given
		
		Cart cart = new Cart(Arrays.asList(new ProductItem(new Product("A", 50, 0), 5),
				new ProductItem(new Product("B", 30, 0), 5),
				new ProductItem(new Product("C", 20, 0), 1)
				));
		
		double expectedValue = 370;
		
		// When
		
		double actualValue = this.priceService.calculatePromotedTotalPrice(cart);
		
		// Then
		
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	void should_return_280_when_3A_5B_1C_1D_Ordered() {
		
		// Given
		
		Cart cart = new Cart(Arrays.asList(new ProductItem(new Product("A", 50, 0), 3),
				new ProductItem(new Product("B", 30, 0), 5),
				new ProductItem(new Product("C", 20, 0), 1),
				new ProductItem(new Product("D", 15, 0), 1)
				));
		
		double expectedValue = 280;
		
		// When
		
		double actualValue = this.priceService.calculatePromotedTotalPrice(cart);
		
		// Then
		
		assertEquals(expectedValue, actualValue);
		
	}

}
