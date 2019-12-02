package com.projetobase.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.Category;
import com.projetobase.model.repository.CategoryRepository;

public class CategoryTestes extends AbstractIntegrationTests {
	@Autowired
	private CategoryService CategoryService;
	
	@Autowired
	private CategoryRepository CategoryRepository;
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	@Test
	@Sql({ "/dataset/category.sql"})
	public void cadastrarCategoryMustPass() {
		
		Category category = new Category();
		category.setName("Portugues");
		
		CategoryService.cadastrarCategory(category);
		
		Assert.assertNotNull(category.getId());
		
		
		
	}
}



	