package com.promineotech.fishingApi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

 

 


@Entity
public class WaterBody {
	
	private Long waterBodyId;
	private String name;
	private String fishery_type;
	private String species;
	@JsonIgnore
	private Set<User> users;     //changed from users
 	private Set<Results> results;
	
	private Location location;
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return waterBodyId;
	}
	
	public void setWater_id(Long id) {
		this.waterBodyId = id;
	}
	
     
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFishery_type() {
		return fishery_type;
	}

	public void setFishery_type(String fishery_type) {
		this.fishery_type = fishery_type;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)                //Many to Many with the User Table
	@JoinTable(name = "fishing_hole",
	joinColumns = @JoinColumn(name = "waterBodyId", referencedColumnName = "waterBodyId"), 
	inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
	public Set<User> getUsers() {         //??getUsers  return users 
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users  = users;
	}

 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "waterBody")                //One to Many with the Results Table
	public Set<Results> getResults() {
		return results;
	}

	public void setResults(Set<Results> results) {
		this.results = results;
	}

	@OneToOne(cascade = CascadeType.ALL)          //One to One with the Location Table
	@JoinColumn(name = "location_id")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


}
