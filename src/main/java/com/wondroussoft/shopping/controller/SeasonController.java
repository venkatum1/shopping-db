package com.wondroussoft.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wondroussoft.shopping.model.entities.Season;
import com.wondroussoft.shopping.model.repo.SeasonRepository;

@Controller
public class SeasonController {

	@Autowired
	SeasonRepository repoSeason;

	@GetMapping("/seasons")
	public String getSeasons(ModelMap map) {
		List<Season> seasons = repoSeason.findAll();

		map.put("seasons", seasons);

		return "seasons";
	}

	@GetMapping("/seasons/{seasonId}")
	public String getSeasonDetails(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Optional<Season> season = repoSeason.findById(seasonId);

		map.put("season", season.get());

		return "season_detail";
	}

	@PostMapping("/season")
	public String createSeason(ModelMap map, @ModelAttribute Season season) {
		// Get the season from UI
		// Save it to DB

		repoSeason.save(season);

		// Fetch all seasons from season table
		List<Season> seasons = repoSeason.findAll();

		// map it to seasons variable
		map.put("seasons", seasons);

		// return the seasons list page
		return "seasons";
	}

	@GetMapping("/season/{seasonId}/edit")
	public String getEditSeasonForm(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Optional<Season> season = repoSeason.findById(seasonId);

		map.put("season", season.get());
		// return the create season page
		return "create_season";
	}

	@GetMapping("/season")
	public String getCreateSeasonForm(ModelMap map) {

		// return the create season page
		return "create_season";
	}

	@GetMapping("/season/{seasonId}")
	public String deleteSeason(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {

		repoSeason.deleteById(seasonId);

		// Fetch all seasons from season table
		List<Season> seasons = repoSeason.findAll();

		// map it to seasons variable
		map.put("seasons", seasons);

		// return the seasons list page
		return "seasons";
	}

}
