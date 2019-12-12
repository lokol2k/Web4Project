package com.projetobase.application.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetobase.model.entity.QuestionSetup;
import com.projetobase.model.entity.Quiz;
import com.projetobase.model.service.QuizService;

@Component
@RestController
@RequestMapping("/api/quiz")
public class QuizResourcer {

	@Autowired
	private QuizService quizService;
	


	@GetMapping("/list")
	public List<Quiz> listar() {
		return this.quizService.listarQuiz();
	}
	
	@GetMapping("/find")
	public Quiz detalhar(@RequestParam("id") Long id) {
		return this.quizService.detalharQuiz(id);
	}
	
	@GetMapping("/quizQuestions")
	public List<QuestionSetup> quizQuestionsByQuizId(@RequestParam("id") Long id){
		return this.quizService.quizQuestionSetup(id);
	}

}




