package com.credit.card.service;

import org.springframework.stereotype.Service;

@Service
public interface PancardService {

	public void getSavePancard();
	public String searchPancard(String pancardNumber);
}
