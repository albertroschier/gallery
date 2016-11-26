package gallery.model;

import java.util.List;

public class Album {
	
	private Integer albumid;

	private String name;
	
	private List<Image> images;

	public Integer getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}