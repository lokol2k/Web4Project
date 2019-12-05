package com.projetobase.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;

import com.projetobase.model.entity.QuestionSetup;

public interface QuestionSetupRepository {

	@EntityGraph(attributePaths = "questionSetup")
	public Optional<QuestionSetup> findById(Long id);
}
