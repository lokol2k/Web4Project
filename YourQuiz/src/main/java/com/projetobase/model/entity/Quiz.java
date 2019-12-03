package com.projetobase.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
	
	@NotBlank
	private LocalDateTime startDate;
	
	@NotBlank
	private LocalDateTime endDate;
	
	@NotBlank
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
	
	
	
	
	/*TO DO  set object QuesntionSetup*/
}


