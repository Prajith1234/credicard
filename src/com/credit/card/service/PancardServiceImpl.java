/**
 * 
 */
package com.credit.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credit.card.dao.PancardDao;

/**
 * @author sairam
 *
 */
@Service
public class PancardServiceImpl implements PancardService {

	@Autowired
	PancardDao pancardDao;

	@Override
	public void getSavePancard() {
		pancardDao.savePancards();
	}

	@Override
	public String searchPancard(String pancardNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
