package gallery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

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
	public User getUser(String username) {
		return jdbcTemplate.queryForObject("SELECT username, first_name, last_name FROM user WHERE username = ?", new Object[] {username}, new UserRowMapper());
	}

	@Override
	public List<User> listUser() {
		return jdbcTemplate.query("SELECT username, first_name, last_name FROM user", new UserRowMapper());
	}

}

class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet arg0, int arg1) throws SQLException {
		User u = new User();
		u.setUsername(arg0.getString("username"));
		u.setFirstname(arg0.getString("first_name"));
		u.setLastname(arg0.getString("last_name"));
		return u;
	}
	
}