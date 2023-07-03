package com.marvel.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor //lombok frees you from generating all the code commented
public class Character {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name attribute is mandatory")
	private String name;
	private String description;
	private String superPowers;

	public Character(String name, String description, String superPowers) {
		super();
		this.name = name;
		this.description = description;
		this.superPowers = superPowers;
	}

	public Character(Long id, String name, String description, String superPowers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.superPowers = superPowers;
	}

	public Character() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuperPowers() {
		return superPowers;
	}

	public void setSuperPowers(String superPowers) {
		this.superPowers = superPowers;
	}
	
}

/*"path": "http://i.annihil.us/u/prod/marvel/i/mg/5/a0/538615ca33ab0",
          "extension": "jpg"
 * "path": "http://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55",
          "extension": "jpg"
          
*/