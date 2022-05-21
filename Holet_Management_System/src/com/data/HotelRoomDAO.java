package com.data;

import java.util.List;

import com.model.HotelRoom;

public interface HotelRoomDAO {
	public List<HotelRoom> getHotelRooms() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addHotelRoom(HotelRoom hotelroom) throws Exception;
	
	public void deleteHotelRoom(int id) throws Exception;
	
	public List<HotelRoom> searchHotelRooms(String fullName) throws Exception;
	
	public HotelRoom getHotelRoom(int id) throws Exception;
	
	public void updateHotelRoom(HotelRoom hotelroom) throws Exception;

}
