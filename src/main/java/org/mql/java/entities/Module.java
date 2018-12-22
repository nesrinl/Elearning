package org.mql.java.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Module")
public class Module {
 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="mod_id")
  private int id ;
	
	@Column(name="title")
   private String title;
	
	@Column(name="description")
   private String description;
	
	@Column(name="reting")
   private float reting;
	
	@Column(name="type")	
   private String type ; 
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tim_id")
	private Timing timing;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="form_id")
	private Formation formation;
	
	@OneToMany(mappedBy= "module" , cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private  List<Streaming> streams;
	
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	public Module() {
		// TODO Auto-generated constructor stub
	}
	public Module(String title, String description, float reting, String type) {
		super();
		this.title = title;
		this.description = description;
		this.reting = reting;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public Timing getTiming() {
		return timing;
	}
	public void setTiming(Timing timing) {
		this.timing = timing;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getReting() {
		return reting;
	}
	public void setReting(float reting) {
		this.reting = reting;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Streaming> getStreams() {
		return streams;
	}
	public void setStreams(List<Streaming> streams) {
		this.streams = streams;
	}
	public void add(Streaming stream) {
		if (streams == null) {
			
			streams = new ArrayList<Streaming>();
			
		}
		streams.add(stream);
		stream.setModule(this);
	}
	
	@Override
	public String toString() {
		return "Module [id=" + id + ", title=" + title + ", description=" + description + ", reting=" + reting
				+ ", type=" + type + ", timing=" + timing + ", formation=" + formation + "]";
	}

		
	
	
	
	

}
