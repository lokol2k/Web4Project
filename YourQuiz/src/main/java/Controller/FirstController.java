package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
@RequestMapping("/")
	public String index() {
	return "Greetings from Spring Boot!";
	
	}
}
