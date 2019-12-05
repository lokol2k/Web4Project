package com.projetobase.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import com.projetobase.model.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	Quiz findByQuizHeader(String quizHeader);
	

	@Override
	@EntityGraph(attributePaths = "quiz")
	public Optional<Quiz> findById(Long id);
	
	
}
