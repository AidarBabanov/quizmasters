package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.Quiz;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface QuizRepository {

    public List<Quiz> getAllQuizzes();

    public List<Quiz> getAllUserQuizzes(int userId);

    public Quiz getQuizById(int id);

    public boolean insertQuiz(Quiz quiz);

    public boolean updateQuiz(Quiz quiz);

    public boolean removeQuiz(Quiz quiz);
}
