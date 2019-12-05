package com.projetobase.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.QuestionSetupAnswer;

public interface QuestionSetupAnswerRepository extends JpaRepository<QuestionSetupAnswer, Long>{
	
	
	public <Optional>QuestionSetupAnswer findById(Long id);
}