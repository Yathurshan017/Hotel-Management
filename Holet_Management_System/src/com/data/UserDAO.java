package com.data;
import com.model.User;

public interface UserDAO {
	
	public void addUser(User user)throws Exception;
	public User getUser(String userId) throws Exception;
	
}
