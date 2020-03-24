package com.kevin.bora.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> listar() {
		
		Category cat1 = new Category(1, "Sport");
		Category cat2 = new Category(2, "Party");

		List<Category> listCategories = new ArrayList<>();
		
		listCategories.add(cat1);
		listCategories.add(cat2);
		
		return listCategories;
	}
}