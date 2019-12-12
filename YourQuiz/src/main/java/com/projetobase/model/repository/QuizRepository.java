package com.projetobase.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetobase.model.entity.QuestionSetup;
import com.projetobase.model.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	
	@Query("FROM Quiz quiz "
			+ "WHERE ( quiz.quizHeader LIKE '%' || :quizHeader || '%' OR :quizHeader IS NULL)")
	public	Page<Quiz> findByQuizHeader(String quizHeader, Pageable pageable);
	
	@Query("FROM QuestionSetup questionSetup " + "WHERE quiz_id = :id")
	public List<QuestionSetup> findQuestionsByQuizId(Long id);

	
	@Override
	@EntityGraph(attributePaths = "category")
	public Optional<Quiz> findById(Long id);
	
	
	public Page<Quiz> findByCategoryId(long id, Pageable pageable);
	

}
