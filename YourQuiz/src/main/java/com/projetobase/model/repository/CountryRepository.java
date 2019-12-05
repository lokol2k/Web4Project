package com.projetobase.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.Country;


public interface CountryRepository extends JpaRepository<Country, Long>{
	
	Optional<Country> findById(Long id);
	
	Country findByName(String name);
}
