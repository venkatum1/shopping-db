package com.wondroussoft.shopping.model.repo;

import org.springframework.stereotype.Repository;

import com.wondroussoft.shopping.model.entities.Season;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Long> {
	List<Season> findAll();
}
