package com.projetobase.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Quiz extends AbstractEntity{ 


	
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
	

	@NotBlank
	@Column(nullable = false)
	private User user;


	public void setUser(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/*TO DO  set object QuesntionSetup*/
}


