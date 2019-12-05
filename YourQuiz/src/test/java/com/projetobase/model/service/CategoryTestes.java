package com.projetobase.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.Category;
import com.projetobase.model.repository.CategoryRepository;

public class CategoryTestes extends AbstractIntegrationTests {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	@Test
	public void cadastrarCategoryMustPass() {
		
		Category category = new Category();
		category.setId(100L);
		category.setName("Ingles");
		
		categoryService.cadastrarCategory(category);
		
		Assert.assertNotNull(category.getId());
		}
	
	// ====================================== LISTAR =========================================
		@Test
		@Sql({ "/dataset/truncate.sql",  
			"/dataset/category.sql", 
			"/dataset/category.sql",
			"/dataset/usuarios.sql"})
		public void listarCategoryMustPass() {
			List<Category> category = this.categoryService.listarCategory();
			Assert.assertEquals(category.size(), 4);

		}
	// ====================================== EDITAR =========================================
		public void editarCategoryMustPass() {
			Category category = new Category();
			category.setName("Pop");
			category.setUpdated(LocalDateTime.now());
			
			categoryService.cadastrarCategory(category);
				Assert.assertNotNull(category.getId());
		}
	
	public void atualizarCategoryMustPass() {
		Category category = this.categoryRepository.findById(1001L).orElse(null);
		

		categoryService.atualizarCategory(category);

		Assert.assertTrue(category.getName() != "");

	}
		
}



	