package com.projetobase.model.service;

import java.util.List;

import com.projetobase.model.entity.Quiz;

public class QuizService {
	/**
	 * Serviço para inserir um Quiz
	 *
	 * @param quiz
	 * @return
	 */
	public Quiz cadastrarQuiz( Quiz quiz )
	{ 
		quiz.setIsActive(true);
		return quiz;
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
