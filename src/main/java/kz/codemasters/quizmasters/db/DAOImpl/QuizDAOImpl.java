package kz.codemasters.quizmasters.db.DAOImpl;

import kz.codemasters.quizmasters.db.DAO.QuizDAO;
import kz.codemasters.quizmasters.model.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public class QuizDAOImpl implements QuizDAO {

    private EntityManager entityManager;

    public QuizDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Quiz> getAllQuizzes() {
        String queryStr = "SELECT q FROM Quiz q";
        Query query = entityManager.createQuery(queryStr, Quiz.class);
        List<Quiz> quizList = query.getResultList();
        return quizList;
    }

    public List<Quiz> getAllUserQuizzes(int userId) {
        String queryStr = "SELECT q FROM Quiz q WHERE q.userId = :userId";
        Query query = entityManager.createQuery(queryStr, Quiz.class)
                .setParameter("userId", userId);
        List<Quiz> quizList = query.getResultList();
        return quizList;
    }

    public Quiz getQuizById(int id) {
        Quiz quiz = entityManager.find(Quiz.class, id);
        return quiz;
    }

    public boolean insertQuiz(Quiz quiz) {
        try {
            entityManager.persist(quiz);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateQuiz(Quiz quiz) {
        try {
            entityManager.merge(quiz);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeQuiz(Quiz quiz) {
        try {
            entityManager.remove(quiz);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
