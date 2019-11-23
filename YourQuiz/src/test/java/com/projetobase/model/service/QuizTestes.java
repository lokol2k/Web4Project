package com.projetobase.model.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.Quiz;
import com.projetobase.model.entity.RoleEnum;
import com.projetobase.model.entity.Usuario;
import com.projetobase.model.repository.UsuarioRepository;

public class QuizTestes {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	//======== CADASTRAR QUIZ =============
	
	@Test
	@Sql({
		"/dataset/truncate.sql",
				"/dataset/quiz.sql"})
		public void cadastrarQuizMustPass() {
			Quiz quiz = new Quiz();
			quiz.setQuizHeader("Pronomes");
			quiz.setDescription("Quiz de pronomes e etc");
			quiz.setStartDate("2019-11-21");
			quiz.setEndDate("2019-11-23");
			Usuario usuario = this.usuarioRepository.findById(1001L).orElse(null);
			quiz.setUser(usuario);
		}
}