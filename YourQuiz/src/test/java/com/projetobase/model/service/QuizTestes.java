package com.projetobase.model.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetobase.model.entity.Category;
import com.projetobase.model.entity.Quiz;
import com.projetobase.model.entity.Usuario;
import com.projetobase.model.repository.CategoryRepository;
import com.projetobase.model.repository.QuizRepository;
import com.projetobase.model.repository.UsuarioRepository;


public class QuizTestes extends AbstractIntegrationTests{
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	//======== CADASTRAR QUIZ =============
	
	@Test
		public void cadastrarQuizMustPass() {
			Quiz quiz = new Quiz();
			quiz.setQuizHeader("Pronomes");
			quiz.setDescription("Quiz de pronomes e etc");
			quiz.setStartDate(LocalDateTime.of(2019, 11, 21, 10, 11));
			quiz.setEndDate(LocalDateTime.of(2019, 11, 23, 10, 11));
			quiz.setIsActive(true);
			Usuario usuario = this.usuarioRepository.findById(1001L).orElse(null);
			quiz.setUsuario(usuario);
			Category category = this.categoryRepository.findById(1L).orElse(null);
			quiz.setCategory(category);
			
			quizService.cadastrarQuiz(quiz);
				Assert.assertNotNull(quiz.getId());
		}

	
	//======== EDITAR QUIZ =============
	
		@Test
			public void editarQuizMustPass() {
				Quiz quiz = new Quiz();
				quiz.setQuizHeader("Pronomes");
				quiz.setDescription("Quiz de pronomes e etc");
				quiz.setStartDate(LocalDateTime.of(2019, 11, 21, 10, 11));
				quiz.setEndDate(LocalDateTime.of(2019, 11, 23, 10, 11));
				quiz.setIsActive(true);
				Usuario usuario = this.usuarioRepository.findById(1001L).orElse(null);
				quiz.setUsuario(usuario);
				Category category = this.categoryRepository.findById(1L).orElse(null);
				quiz.setCategory(category);
				
				quizService.cadastrarQuiz(quiz);
					Assert.assertNotNull(quiz.getId());
			}
		public void atualizarQuizMustPass() {
			Quiz quiz = this.quizRepository.findById(1001L).orElse(null);
			

			quizService.atualizarQuiz(quiz);

			Assert.assertTrue(quiz.getStartDate().getYear() == 1990);

		}
	
	
}