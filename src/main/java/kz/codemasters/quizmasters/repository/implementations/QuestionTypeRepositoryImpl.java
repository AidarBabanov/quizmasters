package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuestionTypeRepository;
import kz.codemasters.quizmasters.model.QuestionType;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
@Stateless
public class QuestionTypeRepositoryImpl implements QuestionTypeRepository {

    @PersistenceContext(name = "QuizMastersPU")
    EntityManager entityManager;

    public List<QuestionType> getAllQuestionTypes() {
        String queryStr = "SELECT q FROM QuestionType q";
        Query query = entityManager.createQuery(queryStr, QuestionType.class);
        return query.getResultList();
    }

    public QuestionType getQuestionTypeById(int id) {
        try {
            return entityManager.find(QuestionType.class, id);
        } catch (NoResultException e) {
            return null;
        }

    }

    public boolean insertQuestionType(QuestionType questionType) {
        try {
            entityManager.persist(questionType);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean updateQuestionType(QuestionType questionType) {
        try {
            entityManager.merge(questionType);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean removeQuestionType(QuestionType questionType) {
        try {
            entityManager.remove(questionType);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
