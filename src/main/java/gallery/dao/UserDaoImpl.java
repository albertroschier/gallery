package gallery.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gallery.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public User getUser(int username) {
		return jdbcTemplate.queryForObject("SELECT username, first_name, last_name FROM user WHERE username = ?", new Object[] {username}, new UserRowMapper());
	}

	@Override
	public List<User> listUser() {
		return jdbcTemplate.query("SELECT username, first_name, last_name FROM user", new UserRowMapper());
	}

}
