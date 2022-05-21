package com.data;

import java.util.List;

import com.model.Transport;

public interface TransportDAO {
	public List<Transport> getTransports() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addTransport(Transport transport) throws Exception;
	
	public void deleteTransport(int id) throws Exception;
	
	public List<Transport> searchTransports(String fullName) throws Exception;
	
	public Transport getTransport(int id) throws Exception;
	
	public void updateTransport(Transport transport) throws Exception;

}
