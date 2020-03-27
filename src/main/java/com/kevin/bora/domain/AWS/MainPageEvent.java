package com.kevin.bora.domain.AWS;
/*package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.kevin.bora.domain.AWS.Photo;
import com.kevin.bora.domain.AWS.Status;
import com.kevin.bora.domain.AWS.Video;

@Entity
public class MainPageEvent  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy="mainPageEvent")
	@JoinColumn(name="event_id")
	private Event event;
	/*
	private List<Video> videos = new ArrayList<>();
	private List<Post> posts= new ArrayList<>();
	private List<Photo> photos= new ArrayList<>();
	private List<Status> status= new ArrayList<>();
	
	public MainPageEvent() {
	}
	
	public MainPageEvent(Integer id, Event event) {
		this.event = event;
	}
	/*
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
		MainPageEvent other = (MainPageEvent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}