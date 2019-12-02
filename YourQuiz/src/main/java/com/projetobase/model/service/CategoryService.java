package com.projetobase.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetobase.model.entity.Category;
import com.projetobase.model.repository.CategoryRepository;


public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category cadastrarCategory(Category category)
	{ 
		return this.categoryRepository.save(category);
	}
	
	
	
}
