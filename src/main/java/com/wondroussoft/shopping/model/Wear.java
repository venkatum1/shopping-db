package com.wondroussoft.shopping.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Wear {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long SeasonId;
	
    public Wear(Long id, String name, Long SeasonId) {
		this.id = id;
		this.name = name;
		this.SeasonId = SeasonId;
	}
    
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSeasonId() {
		return SeasonId;
	}

	public void setSeasonId(Long SeasonId) {
		this.SeasonId = SeasonId;
	}

}
