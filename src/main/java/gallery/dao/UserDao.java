package gallery.dao;

import java.util.List;

import gallery.model.User;

public interface UserDao {
	
	User getUser(String username);
	
	List<User> listUser();
	
}