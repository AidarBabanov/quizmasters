package db.DAO;

import db.model.Quiz;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface QuizDAO {

    public List<Quiz> getAllQuizzes();

    public List<Quiz> getAllUserQuizzes(int userId);

    public Quiz getQuizById(int id);

    public Quiz getQuizByName(String name);

    public boolean insertQuiz(int userId, String name);

    public boolean updateQuiz(int id, String name);

    public boolean removeQuiz(int id);
}
