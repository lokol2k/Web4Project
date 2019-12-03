package com.projetobase.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 665426621504404261L;

	@NotBlank
	@Column(nullable = false, length = 200)
	@Size(max = 100)
	private String name;
	
	
	@JsonIgnoreProperties("category")
	@OneToMany(targetEntity = Quiz.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.EAGER, mappedBy = "category", orphanRemoval = true)
	private List<Quiz> quiz = new ArrayList<Quiz>();
}

