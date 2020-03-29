package com.kevin.bora.domain.AWS;

import java.util.ArrayList;
import java.util.List;

public class Status {
	
	private Integer id;

	private List<Video> videos = new ArrayList<>();
	private List<Post> posts = new ArrayList<>();
	private List<Photo> photos = new ArrayList<>();
	private List<Status> status= new ArrayList<>();
	
	public Status() {
	}

	public Status(Integer id, List<Video> videos, List<Post> posts, List<Photo> photos, List<Status> status) {
		super();
		this.id = id;
		this.videos = videos;
		this.posts = posts;
		this.photos = photos;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}