package com.projetobase.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.projetobase.model.entity.QuestionSetup;
import com.projetobase.model.entity.Quiz;
import com.projetobase.model.repository.QuizRepository;

@Service
@Transactional
public class QuizService {
	
	
	@Autowired
	private QuizRepository quizRepository;
	
	/**
	 * Serviço para inserir um Quiz
	 *
	 * @param quiz
	 * @return
	 */
	public Quiz cadastrarQuiz(Quiz quiz)
	{ 
		return this.quizRepository.save(quiz);
	}
	/**
	 * Serviço para atualizar um Quiz
	 *
	 * @param quiz
	 * @return
	 */
	public Quiz atualizarQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}
	/**
	 * Serviço para lsitar quizes
	 *
	 * @param quiz
	 * @return
	 */
	public List<Quiz> listarQuiz(){
		return this.quizRepository.findAll();
	}
	
	public List<QuestionSetup> quizQuestionSetup(Long id){
		return this.quizRepository.findQuestionsByQuizId(id);
	}
	
	/**
	 * Serviço para detalhar um Quiz
	 *
	 * @param quiz
	 * @return
	 */
	public Quiz detalharQuiz(long id) {
		
		Quiz  quiz = this.quizRepository.findById(id).orElse(null);
		
		Assert.notNull(quiz, "O Id do quiz"+ id +" não foi encontrado.");
		
		return quiz;
	}
	/**
	 * Serviço para remover um Quiz
	 *
	 * @param quiz
	 * @return
	 */
	public void removerQuiz(long id) {
		this.quizRepository.deleteById(id);
	}
	/**
	 * Serviço para listar um Quiz por sua category
	 *
	 * @param quiz
	 * @return
	 */
	public Page<Quiz> listarQuizByCategory(long categoryId, PageRequest pageable){
		return this.quizRepository.findByCategoryId(categoryId, pageable);
	}
	/**
	 * Serviço para listar um Quiz por seu nome
	 * 
	 *
	 * @param quiz
	 * @return
	 */
	public Page<Quiz> listarQuizByHeaderQuiz(String headerQuiz, PageRequest pageable){
		return this.quizRepository.findByQuizHeader(headerQuiz, pageable);
	}


	}
