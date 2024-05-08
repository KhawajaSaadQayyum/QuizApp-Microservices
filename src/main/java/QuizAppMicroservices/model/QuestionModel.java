package QuizAppMicroservices.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Questions")
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer Id;
    private String questionTitle;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

}
