package gallery.dao;

import java.util.List;

import gallery.model.User;

public interface UserDao {
	
	User getUser(int username);
	
	List<User> listUser();
	
}
