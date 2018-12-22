package org.mql.java.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "timing")
public class Timing {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="tim_id")
  private int id ;
	
	@Column(name="dayname")
   private String dayname;
	
	@Column(name="hour")
   private int  hour;
	
	@Column(name="minute")
	   private int  minute;
	
	@Column(name="duration")
	   private int  duration;
	
	public Timing() {
		// TODO Auto-generated constructor stub
	}
	
	public Timing(String dayname, int hour, int minute, int duration) {
		super();
		this.dayname = dayname;
		this.hour = hour;
		this.minute = minute;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDayname() {
		return dayname;
	}

	public void setDayname(String dayname) {
		this.dayname = dayname;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Timing [id=" + id + ", dayname=" + dayname + ", hour=" + hour + ", minute=" + minute + ", duration="
				+ duration + "]";
	}
	
	
	
	


	

}
