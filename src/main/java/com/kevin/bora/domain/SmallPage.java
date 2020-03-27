package com.kevin.bora.domain;

import java.util.ArrayList;
import java.util.List;

import com.kevin.bora.domain.AWS.Photo;

public class SmallPage {

	private Integer id;
	private String description;
	
	private List<Post> posts = new ArrayList<>();
	private Localization location;
	private Event event;
	private List<Photo> photos = new ArrayList<>();

	public SmallPage() {
	}

	public SmallPage(Integer id, String description, Localization location, Event event) {
		super();
		this.id = id;
		this.description = description;
		this.location = location;
		this.event = event;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Localization getLocation() {
		return location;
	}

	public void setLocation(Localization location) {
		this.location = location;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
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
		SmallPage other = (SmallPage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}