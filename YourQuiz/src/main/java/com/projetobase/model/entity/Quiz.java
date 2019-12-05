package com.projetobase.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Quiz extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(nullable = false, length = 200)
	@Size(max = 100)
	private String quizHeader;
	
	@NotBlank
	@Column(nullable = true, length = 300)
	@Size(max = 100)
	private String description;
	
	@NotNull
	private LocalDateTime startDate;
	
	@NotNull
	private LocalDateTime endDate;
	
	@NotNull
	@Column(nullable = false)
	private Boolean isActive;
	

	@JsonIgnoreProperties("quiz")
	@ManyToOne(targetEntity = Usuario.class,
			fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@JsonIgnoreProperties("quiz")
	@ManyToOne(targetEntity = Category.class,
			fetch = FetchType.LAZY)
	private Category category;
	

	@JsonIgnoreProperties("quiz")
	@OneToMany(targetEntity = QuestionSetup.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.EAGER, mappedBy = "quiz", orphanRemoval = true)
	private List<QuestionSetup> questionSetup = new ArrayList<QuestionSetup>();
	
	
}


