package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.Question;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuestionRepository {

    List<Question> getAllQuestions();

    List<Question> getAllQuizQuistions(int quizId);

    Question getQuestionById(int id);

    boolean insertQuestion(Question question);

    boolean updateQuestion(Question question);

    boolean removeQuestion(Question question);
}
