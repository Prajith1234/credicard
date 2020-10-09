package com.credit.card.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PancardDao {
	public void savePancards();
	public String searchPancard(String pancardNumber);
}
