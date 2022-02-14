package com.promotion.engine.repository;

import java.util.List;

import com.promotion.engine.model.Promotion;

public interface IPromotionRepository {
	public List<Promotion> getPromotionList();
}
