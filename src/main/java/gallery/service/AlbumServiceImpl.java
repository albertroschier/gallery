package gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gallery.dao.AlbumDao;
import gallery.model.Album;

@Transactional
@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public Album getAlbum(int albumid) {
		return albumDao.getAlbum(albumid);
	}

	@Override
	public List<Album> listAlbums() {
		
		List<Album> albums = albumDao.listAlbums();
		return albums;
	}
}