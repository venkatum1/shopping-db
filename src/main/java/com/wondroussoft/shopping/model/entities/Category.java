package com.wondroussoft.shopping.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long wearId;
	

	public Category() {
	}

	public Category(Long id, String name, Long wearId) {
		this.id = id;
		this.name = name;
		this.wearId = wearId;
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
		return wearId;
	}

	public void setWearId(Long wearId) {
		this.wearId = wearId;
	}

	public static void add(Category category) {
		// TODO Auto-generated method stub
		
	}

}
