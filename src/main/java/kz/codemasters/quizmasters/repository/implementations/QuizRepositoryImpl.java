package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;
import kz.codemasters.quizmasters.model.Quiz;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
@Stateless
public class QuizRepositoryImpl implements QuizRepository {

    @PersistenceContext(name = "QuizMastersPU")
    private EntityManager entityManager;

    public List<Quiz> getAllQuizzes() {
        String queryStr = "SELECT q FROM Quiz q";
        Query query = entityManager.createQuery(queryStr, Quiz.class);
        return (List<Quiz>) query.getResultList();
    }

    public List<Quiz> getAllUserQuizzes(int userId) {
        String queryStr = "SELECT q FROM Quiz q WHERE q.userId = :userId";
        Query query = entityManager.createQuery(queryStr, Quiz.class)
                .setParameter("userId", userId);

        return (List<Quiz>) query.getResultList();

    }

    public Quiz getQuizById(int id) {
        try {
            return entityManager.find(Quiz.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean insertQuiz(Quiz quiz) {
        try {
            entityManager.persist(quiz);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean updateQuiz(Quiz quiz) {
        try {
            entityManager.merge(quiz);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean removeQuiz(Quiz quiz) {
        try {
            entityManager.remove(quiz);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
