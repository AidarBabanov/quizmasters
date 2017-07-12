package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuestionRepository;
import kz.codemasters.quizmasters.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class QuestionRepositoryImpl implements QuestionRepository {

    private EntityManager entityManager;

    public QuestionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Question> getAllQuestions() {
        String queryStr = "SELECT q FROM Question q";
        Query query = entityManager.createQuery(queryStr, Question.class);
        List<Question> questionsList = query.getResultList();
        return questionsList;
    }

    public List<Question> getAllQuizQuistions(int quizId) {
        String queryStr = "SELECT q FROM Question q WHERE q.quizId = :quizId";
        Query query = entityManager.createQuery(queryStr, Question.class)
                .setParameter("quizId", quizId);
        List<Question> questionList = query.getResultList();
        return questionList;
    }

    public Question getQuestionById(int id) {
        Question question = entityManager.find(Question.class, id);
        return question;
    }

    public boolean insertQuestion(Question question) {
        try {
            entityManager.persist(question);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateQuestion(Question question) {
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

