package com.projetobase.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Optional<Category> findById(Long Id);
	
	Category findByName(String Name);
}
