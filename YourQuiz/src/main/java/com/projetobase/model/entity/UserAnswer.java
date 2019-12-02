package com.projetobase.model.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnoreProperties("QuestionSetupAnswer")
	@OneToMany(targetEntity = QuestionSetup.class,
			fetch = FetchType.LAZY)
	private QuestionSetup questionSetup;
	
	@JsonIgnoreProperties("quiz")
	@OneToMany(targetEntity = Usuario.class,
			fetch = FetchType.LAZY)
	private Usuario usuario;
}
