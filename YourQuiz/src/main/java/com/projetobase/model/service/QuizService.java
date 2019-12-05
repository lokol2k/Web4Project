package com.projetobase.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
	public void removerQuiz(long id) {
		this.quizRepository.deleteById(id);
	}
	
	}
