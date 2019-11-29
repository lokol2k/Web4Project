package com.projetobase.model.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.Quiz;
import com.projetobase.model.entity.Usuario;
import com.projetobase.model.repository.UsuarioRepository;

public class QuizTestes {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private UsuarioService quizRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	//======== CADASTRAR QUIZ =============
	
	@Test
	@Sql({
				"/dataset/quiz.sql"})
		public void cadastrarQuizMustPass() {
			Quiz quiz = new Quiz();
			quiz.setQuizHeader("Pronomes");
			quiz.setDescription("Quiz de pronomes e etc");
			quiz.setStartDate(LocalDateTime.of(2019, 11, 21, 10, 11));
			quiz.setEndDate(LocalDateTime.of(2019, 11, 23, 10, 11));
			Usuario usuario = this.usuarioRepository.findById((long) 1001).orElse(null);
			quiz.setUser(usuario);
			
			quizService.cadastrarQuiz(quiz);
				Assert.assertNotNull(quiz.getId());
		}

}