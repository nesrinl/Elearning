package org.mql.java.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "streaming")
public class Streaming {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	@Column(name="id")
  private int id ;
	
	@Column(name="title")
   private String title;
	
	@Column(name="url")
   private String url;
	
	@Column(name="TimeStarted")
   private String TimeStarted;
	
	@Column(name="duration")	
   private String duration ; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mod_id")
	private Module module;
	
	public Streaming() {
	
	}

	public Streaming(String title, String url, String timeStarted, String duration) {
		super();
		this.title = title;
		this.url = url;
		this.TimeStarted = timeStarted;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTimeStarted() {
		return TimeStarted;
	}

	public void setTimeStarted(String timeStarted) {
		this.TimeStarted = timeStarted;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	

	@Override
	public String toString() {
		return "Streaming [id=" + id + ", title=" + title + ", url=" + url + ", TimeStarted=" + TimeStarted
				+ ", duration=" + duration + ", module=" + module + "]";
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	

}
