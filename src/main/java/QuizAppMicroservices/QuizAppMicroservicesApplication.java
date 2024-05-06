package QuizAppMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class QuizAppMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppMicroservicesApplication.class, args);
		System.out.println("Welcome to the Microservices Learning");
	}

}
