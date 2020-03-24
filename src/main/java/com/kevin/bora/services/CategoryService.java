package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Category;
import com.kevin.bora.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category find( Integer id ) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
