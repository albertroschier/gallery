package gallery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gallery.model.Image;
import gallery.dao.ImageRowMapper;

@Repository
public class ImageDaoImpl implements ImageDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Image getImage(int imageid) {
		return jdbcTemplate.queryForObject("SELECT imageid, albumid, name, filepath FROM image WHERE imageid=?", new Object[] {imageid}, new ImageRowMapper());
	}

	@Override
	public List<Image> listImages() {
		return jdbcTemplate.query("SELECT imageid, albumid, name, filepath FROM image", new ImageRowMapper());
	}

	public List<Image> listImagesForAlbum(int albumId) {
		return jdbcTemplate.query("SELECT imageid, albumid, name, filepath FROM image WHERE albumid = ?", new Object[] {albumId}, new ImageRowMapper());
	}
}

class ImageRowMapper implements RowMapper<Image> {

	public Image mapRow(ResultSet arg0, int arg1) throws SQLException {
		Image h = new Image();
		h.setImageid(arg0.getInt("imageid"));
		h.setAlbumid(arg0.getInt("albumid"));
		h.setName(arg0.getString("name"));
		h.setFilepath(arg0.getString("filepath"));
		return h;
	}
	
}