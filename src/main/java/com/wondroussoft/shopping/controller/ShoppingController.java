package com.wondroussoft.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	@Autowired
	WearRepository repoWear;
	@GetMapping("/seasons/{seasonId}/wears")
	public String getWearsBySeasonId(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		
		List<Wear> wears = repoWear.findBySeasonId(seasonId);

		
		map.put("wears", wears);

		return "wears";
	}
	@Autowired
	CategoryRepository repoCategory;

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

}
