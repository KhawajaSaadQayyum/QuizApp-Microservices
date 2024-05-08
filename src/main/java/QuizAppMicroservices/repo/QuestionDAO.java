package QuizAppMicroservices.repo;

import QuizAppMicroservices.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<QuestionModel, Integer> {
    List<QuestionModel> findByCategory(String category);
  @Query (value = "SELECT * FROM Questions q WHERE q.category= :category ORDER BY RAND()  LIMIT :numOfQuestions",nativeQuery = true)
    List<QuestionModel> getRandomQuestions(int numOfQuestions, String category);


}
