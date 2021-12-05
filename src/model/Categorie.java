package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categorie {
	@Id
	@GeneratedValue
	private int id;
	
	private String description;
	
	public Categorie(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
