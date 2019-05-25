package com.wondroussoft.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wondroussoft.shopping.model.entities.Category;
import com.wondroussoft.shopping.model.repo.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository repoCategory;

	@GetMapping("/wears/{wearId}/categories")
	public String getCategoryByWearId(ModelMap map, @PathVariable(name = "wearId") Long wearId) {

		List<Category> categories = repoCategory.findByWearId(wearId);

		map.put("categories", categories);

		return "categories";
	}

}
