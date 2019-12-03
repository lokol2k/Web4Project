package com.projetobase.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobase.model.entity.Category;
import com.projetobase.model.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category cadastrarCategory(Category category)
	{ 
		return this.categoryRepository.save(category);
	}
	
	
	
}
