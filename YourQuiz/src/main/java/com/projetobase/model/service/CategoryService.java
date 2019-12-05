package com.projetobase.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
	
	
	/**
	 * Serviço para atualizar uma Category
	 *
	 * @param category
	 * @return
	 */
	public Category atualizarCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	/**
	 * Serviço para lsitar categoryes
	 *
	 * @param category
	 * @return
	 */
	public List<Category> listarCategory(){
		return this.categoryRepository.findAll();
	}
	
	/**
	 * Serviço para detalhar um Category
	 *
	 * @param category
	 * @return
	 */
	public Category detalharCategory(long id) {
		
		Category  category = this.categoryRepository.findById(id).orElse(null);
		
		Assert.notNull(category, "O Id do category"+ id +" não foi encontrado.");
		
		return category;
	}
	/**
	 * Serviço para remover um Category
	 *
	 * @param category
	 * @return
	 */
	public void removerCategory(long id) {
		this.categoryRepository.deleteById(id);
	}
}
