package com.projetobase.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

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
	
	
	
	// ====================================== LISTAR =========================================
	@Test
	@Sql({ "/dataset/truncate.sql",  
		"/dataset/category.sql", 
		"/dataset/quiz.sql",
		"/dataset/usuarios.sql"})
	public void listarQuizMustPass() {
		List<Quiz> quiz = this.quizService.listarQuiz();
		Assert.assertEquals(quiz.size(), 4);

	}
	@Test
	@Sql({ "/dataset/truncate.sql",
		"/dataset/usuario.sql",
		"/dataset/category.sql", 
		"/dataset/quiz.sql" })
	public void listarQuizByCategoryMustPass() {
		List<Quiz> quiz = this.quizService.listarQuizByCategory(1L, null).getContent();
		Assert.assertEquals(quiz.size(), 2);
	}
	@Test
	@Sql({ "/dataset/truncate.sql",  
		"/dataset/category.sql", 
		"/dataset/quiz.sql",
		"/dataset/usuarios.sql"})
	public void listarQuizByHeaderNameMustPass() {
		List<Quiz> quiz = this.quizService.listarQuizByHeaderQuiz("Pronomes",null).getContent();
		Assert.assertEquals(quiz.size(), 2);

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
		
	//======== DELETAR QUIZ =============

		@Test
		@Sql({ "/dataset/truncate.sql",  
			"/dataset/usuario.sql", 
			"/dataset/category.sql",
			"/dataset/quiz.sql" })
		public void removerQuOizMustPass() {
			
			this.quizService.removerQuiz(1001);
			
			Quiz quiz = 
					this.quizRepository.findById(1001L).orElse(null);
			
			Assert.assertNull(quiz);
		}
		
	// ================== DETALHAR ===============================
		 
		@Test()
		@Sql({ "/dataset/truncate.sql",  
			"/dataset/departamentos.sql", 
			"/dataset/quizs.sql" })
		public void detalharQuizMustPass() {
			Quiz quiz = this.quizService.detalharQuiz(1001L);

			Assert.assertNotNull(quiz);
			Assert.assertNotNull(quiz.getId());
			Assert.assertNotNull(quiz.getQuizHeader());
			Assert.assertNotNull(quiz.getDescription());
			Assert.assertNotNull(quiz.getQuestionSetup());
			Assert.assertNotNull(quiz.getCreated());
			Assert.assertNotNull(quiz.getCategory().getName());
			Assert.assertNotNull(quiz.getEndDate());

		}
}