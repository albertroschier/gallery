package gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gallery.dao.UserDao;
import gallery.model.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(int userid) {
		
		return null;
	}

	@Override
	public List<User> listUsers() {
		
		return null;
	}

}