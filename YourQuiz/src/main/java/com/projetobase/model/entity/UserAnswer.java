package com.projetobase.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UserAnswer extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 665426621504404261L;
	
	
	@JsonIgnoreProperties("userAnswer")
	@ManyToOne(targetEntity = QuestionSetupAnswer.class,
			fetch = FetchType.LAZY)
	private QuestionSetupAnswer questionSetupAnswer;

	
	@JsonIgnoreProperties("userAnswer")
	@ManyToOne(targetEntity = Usuario.class,
			fetch = FetchType.LAZY)
	private Usuario usuario;	


}
