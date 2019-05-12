package com.wondroussoft.shopping.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long WearId;
	

	public Category() {
	}

	public Category(Long id, String name, Long WearId) {
		this.id = id;
		this.name = name;
		this.WearId = WearId;
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
		return WearId;
	}

	public void setWearId(Long WearId) {
		this.WearId = WearId;
	}

	public static void add(Category category) {
		// TODO Auto-generated method stub
		
	}

}
