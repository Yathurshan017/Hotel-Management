package com.data;

import java.util.List;

import com.model.Buy;

public interface BuyDAO {
public List<Buy> getBuys() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addBuy(Buy buy) throws Exception;
	
	public void deleteBuy(int id) throws Exception;
	
	public List<Buy> searchBuys(String fullName) throws Exception;
	
	public Buy getBuy(int id) throws Exception;
	
	public void updateBuy(Buy buy) throws Exception;

}
