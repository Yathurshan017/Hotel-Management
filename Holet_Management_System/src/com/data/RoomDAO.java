package com.data;

import java.util.List;

import com.model.Room;

public interface RoomDAO {
	
public List<Room> getRooms() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addRoom(Room room) throws Exception;
	
	public void deleteRoom(int id) throws Exception;
	
	public List<Room> searchRooms(String fullName) throws Exception;
	
	public Room getRoom(int id) throws Exception;
	
	public void updateRoom(Room room) throws Exception;

}
