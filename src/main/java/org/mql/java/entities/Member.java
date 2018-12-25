package org.mql.java.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "member")
public class Member {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="memb_id")
  private int id ;
	
	@Column(name="firstName")
   private String firstName;
	
	@Column(name="lastName")
   private String lastName;
	
	@Column(name="email")
   private String email;
	
	@Column(name="password")	
   private String password ; 
	
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH} )
	@JoinTable(
			name="teach", 
			joinColumns=@JoinColumn(name="memb_id"),
			inverseJoinColumns=@JoinColumn(name="mod_id")
			)
	private List<Module> modules;
	  
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH} )
	@JoinTable(
			name="following", 
			joinColumns=@JoinColumn(name="memb_id"),
			inverseJoinColumns=@JoinColumn(name="form_id")
			)
	private List<Formation> formations ;
	
	public Member() {  
		
	}
	
	public Member(String firstName, String lastName, String email, String password) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy= "member" , cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="form_id")
	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	public void addModules(Module module) {
		if (modules == null) {
			
			modules = new ArrayList<Module>();
			
		}
		modules.add(module);
	}
	

}
