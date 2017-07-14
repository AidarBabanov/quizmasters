package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.Quiz;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface QuizRepository {

    List<Quiz> getAllQuizzes();

    List<Quiz> getAllUserQuizzes(int userId);

    Quiz getQuizById(int id);

    boolean mergeQuiz(Quiz quiz);

    boolean removeQuiz(Quiz quiz);
}
