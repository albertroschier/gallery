package gallery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gallery.model.Album;

@Repository
public class AlbumDaoImpl implements AlbumDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Album getAlbum(int albumid) {
		return jdbcTemplate.queryForObject("SELECT albumid, name FROM album WHERE albumid=?", new Object[] {albumid}, new AlbumRowMapper());
	}

	@Override
	public List<Album> listAlbums() {
		return jdbcTemplate.query("SELECT albumid, name FROM album", new AlbumRowMapper());
	}

}

class AlbumRowMapper implements RowMapper<Album> {

	public Album mapRow(ResultSet arg0, int arg1) throws SQLException {
		Album h = new Album();
		h.setAlbumid(arg0.getInt("albumid"));
		h.setName(arg0.getString("name"));
		return h;
	}
	
}