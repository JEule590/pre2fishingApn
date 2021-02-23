package com.promineotech.fishingApi.entity;

 
import java.util.Set;

 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
 

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	private Long userId;
	private String first_name;
	private String last_name;
	private String city;
	private String state;
	
	//@JsonIgnore
	private Set<WaterBody> waterBodys;
	
 	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getUserId() {
		return userId;
	}
	
	public void setId(Long id) {
		this.userId = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
	public Set<WaterBody> getWaterBodys() {
		 
		return waterBodys;
	}

	public void setWaterBodys(Set<WaterBody> waterBodys) {
		this.waterBodys = waterBodys;
	}
	
 


}
