package com.projetobase.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetobase.model.entity.Country;
import com.projetobase.model.repository.CountryRepository;

public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	
	public Country cadastrarCountry(Country country)
	{ 
		return this.countryRepository.save(country);
	}
	
}
