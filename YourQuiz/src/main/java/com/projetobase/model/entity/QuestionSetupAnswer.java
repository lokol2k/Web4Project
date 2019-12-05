package com.projetobase.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@JsonIgnoreProperties("questionSetupAnswer")
	@ManyToOne(targetEntity = QuestionSetup.class,
			fetch = FetchType.LAZY)
	private QuestionSetup questionSetup;
	
	@JsonIgnoreProperties("questionSetupAnswer")
	@OneToMany(targetEntity = UserAnswer.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.EAGER, mappedBy = "questionSetupAnswer", orphanRemoval = true)
	private List<UserAnswer> userAnswer = new ArrayList<UserAnswer>();
}
