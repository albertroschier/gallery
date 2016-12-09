package gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gallery.dao.UserDao;
import gallery.model.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUser(String username) {
		return userDao.getUser(username);
	}

	public List<User> listUser() {
		return userDao.listUser();
	}

}