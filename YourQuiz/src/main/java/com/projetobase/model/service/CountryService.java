package com.projetobase.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.projetobase.model.entity.Country;
import com.projetobase.model.repository.CountryRepository;

public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	/**
	 * Serviço para inserir um Country
	 *
	 * @param Country
	 * @return
	 */
	public Country cadastrarCountry(Country country)
	{ 
		return this.countryRepository.save(country);
	}
	/**
	 * Serviço para atualizar um Country
	 *
	 * @param Country
	 * @return
	 */
	public Country atualizarCountry(Country Country) {
		return this.countryRepository.save(Country);
	}
	/**
	 * Serviço para lsitar Countryes
	 *
	 * @param Country
	 * @return
	 */
	public List<Country> listarCountry(){
		return this.countryRepository.findAll();
	}
	
	/**
	 * Serviço para detalhar um Country
	 *
	 * @param Country
	 * @return
	 */
	public Country detalharCountry(long id) {
		
		Country  Country = this.countryRepository.findById(id).orElse(null);
		
		Assert.notNull(Country, "O Id do Country"+ id +" não foi encontrado.");
		
		return Country;
	}
	public void removerCountry(long id) {
		this.countryRepository.deleteById(id);
	}
	
}
