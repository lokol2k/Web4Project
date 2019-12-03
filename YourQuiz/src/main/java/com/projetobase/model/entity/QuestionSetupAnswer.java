package com.projetobase.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class QuestionSetupAnswer extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(nullable = false, length = 200)
	@Size(max = 100)
	private String Description;

	@JsonIgnoreProperties("QuestionSetup")
	@ManyToOne(targetEntity = Quiz.class,
			fetch = FetchType.LAZY)
	private Quiz quiz;
}
