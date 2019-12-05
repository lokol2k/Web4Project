package com.projetobase.model.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	Page<Quiz> findByQuizHeader(String quizHeader, Pageable pageable);
	

	@Override
	@EntityGraph(attributePaths = "quiz")
	public Optional<Quiz> findById(Long id);
	
	
public Page<Quiz> findByCategory(Long id, Pageable pageable);
	

}
