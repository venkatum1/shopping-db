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

import com.wondroussoft.shopping.model.entities.Category;
import com.wondroussoft.shopping.model.entities.Item;
import com.wondroussoft.shopping.model.entities.Season;
import com.wondroussoft.shopping.model.entities.Wear;
import com.wondroussoft.shopping.model.repo.CategoryRepository;
import com.wondroussoft.shopping.model.repo.ItemRepository;
import com.wondroussoft.shopping.model.repo.SeasonRepository;
import com.wondroussoft.shopping.model.repo.WearRepository;

@Controller
public class SeasonController {

	@Autowired
	SeasonRepository repoSeason;
	
	@Autowired
	WearRepository repoWear;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	ItemRepository repoItem;

	@GetMapping("/seasons")
	public String getSeasons(ModelMap map) {
		List<Season> seasons = repoSeason.findByX(false);

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

//		// Fetch all seasons from season table
//		List<Season> seasons = repoSeason.findAll();
//
//		// map it to seasons variable
//		map.put("seasons", seasons);
//
//		// return the seasons list page
//		return "seasons";
		
		return "redirect:/seasons";
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

		// repoSeason.deleteById(seasonId);
		Optional<Season> season = repoSeason.findById(seasonId);
		Season newSeason = season.get();
		newSeason.setX(true);
		repoSeason.save(newSeason);
		
		//Here you need to fetch all the related wears and then set x = true
		// Fetch all wears from wear table
		List<Wear> wears = repoWear.findBySeasonId(seasonId);
		
		for(Wear wear: wears) {
			wear.setX(true);
			repoWear.save(wear);
			List<Category> categories = repoCategory.findByWearId(wear.getId());
			for(Category category: categories) {
				category.setX(true);
				repoCategory.save(category);
				List<Item> items = repoItem.findByCategoryId(category.getId());
				for(Item item: items) {
					item.setX(true);
					repoItem.save(item);
				}
			}
		}
		
		

		// Fetch all seasons from season table
		List<Season> seasons = repoSeason.findByX(false);

		// map it to seasons variable
		map.put("seasons", seasons);

		// return the seasons list page
		return "seasons";
	}

}
