package QuizAppMicroservices.service;

import QuizAppMicroservices.model.QuizModel;
import QuizAppMicroservices.repo.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizDAO quizDAO;
    public  List<QuizModel> getAllQuestion() {
      return quizDAO.findAll();
    }

    public void addQuestions(QuizModel questions) {
        quizDAO.save(questions);

    }

//    public List<QuizModel> findByCategory(String categoryType) {
////       return quizDAO.findByCategory(categoryType);
//
//    }
}
