package com.projetobase.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public List<Quiz> listarQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	public Quiz detlharQuiz(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
