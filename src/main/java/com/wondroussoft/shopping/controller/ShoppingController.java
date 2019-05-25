package com.wondroussoft.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ShoppingController {

	@Autowired
	SeasonRepository repoSeason;

	@Autowired
	WearRepository repoWear;

	@Autowired
	CategoryRepository repoCategory;

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

	@GetMapping("/seasons/{seasonId}/wears")
	public String getWearsBySeasonId(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {

		List<Wear> wears = repoWear.findBySeasonId(seasonId);

		map.put("wears", wears);

		return "wears";
	}

	@GetMapping("/wears/{wearId}/categories")
	public String getCategoryByWearId(ModelMap map, @PathVariable(name = "wearId") Long wearId) {

		List<Category> categories = repoCategory.findByWearId(wearId);

		map.put("categories", categories);

		return "categories";
	}

	@Autowired
	ItemRepository repoItem;

	@GetMapping("/categories/{categoryId}/items")
	public String getItemByCategoryId(ModelMap map, @PathVariable(name = "categoryId") Long categoryId) {
		List<Item> items = repoItem.findByCategoryId(categoryId);

		map.put("items", items);

		return "items";
	}

	@GetMapping("/items/{itemId}")
	public String getItemDetails(ModelMap map, @PathVariable(name = "itemId") Long itemId) {

		Optional<Item> item = repoItem.findById(itemId);

		map.put("item", item.get());

		return "item_detail";
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

	@GetMapping("/season")
	public String getCreateSeason(ModelMap map) {

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
