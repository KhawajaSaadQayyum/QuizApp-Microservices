package QuizAppMicroservices.repo;

import QuizAppMicroservices.model.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<QuizModel,Integer> {
//    void getQuizQuestions(String category, int numOfQuestions);
}
