package com.projetobase.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	Quiz findByQuizHeader(String QuizHeader);
	
	
}
