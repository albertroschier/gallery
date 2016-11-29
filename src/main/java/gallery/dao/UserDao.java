package gallery.dao;

import java.util.List;

import gallery.model.User;

public interface UserDao {
	
	User getUser(int userid);
	
	List<User> listUsers();
	
}