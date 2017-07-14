package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuestionRepository;
import kz.codemasters.quizmasters.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class QuestionRepositoryImpl implements QuestionRepository {

    @PersistenceContext(name = "QuizMastersPU")
    private EntityManager entityManager;

    public QuestionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Question> getAllQuestions() {
        String queryStr = "SELECT q FROM Question q";
        Query query = entityManager.createQuery(queryStr, Question.class);
        return query.getResultList();
    }

    public List<Question> getAllQuizQuistions(int quizId) {
        String queryStr = "SELECT q FROM Question q WHERE q.quizId = :quizId";
        Query query = entityManager.createQuery(queryStr, Question.class)
                .setParameter("quizId", quizId);
        return query.getResultList();
    }

    public Question getQuestionById(int id) {
        Question question = entityManager.find(Question.class, id);
        try {
            return question;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean mergeQuestion(Question question) {
        try {
            entityManager.merge(question);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeQuestion(Question question) {
        try {
            entityManager.remove(question);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

