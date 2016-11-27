package gallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Image {
	
	private Integer imageid;
	
	private Integer albumid;

	private String name;
	
	@JsonIgnore
	private String filepath;

	public Integer getImageid() {
		return imageid;
	}

	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}
	
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

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}