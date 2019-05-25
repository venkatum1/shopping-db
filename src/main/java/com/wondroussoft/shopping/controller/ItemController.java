package com.wondroussoft.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.wondroussoft.shopping.model.entities.Item;
import com.wondroussoft.shopping.model.repo.ItemRepository;

@Controller
public class ItemController {

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
