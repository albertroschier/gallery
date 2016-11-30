package gallery.service;

import java.util.List;

import gallery.model.User;

public interface UserService {

	User getUser(int username);
	
	List<User> listUser();
	
}