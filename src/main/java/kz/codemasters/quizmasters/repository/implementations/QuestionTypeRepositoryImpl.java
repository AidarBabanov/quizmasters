package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuestionTypeRepository;
import kz.codemasters.quizmasters.model.QuestionType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class QuestionTypeRepositoryImpl implements QuestionTypeRepository {

    EntityManager entityManager;
    public QuestionTypeRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<QuestionType> getAllQuestionTypes() {
        String queryStr = "SELECT q FROM QuestionType q";
        Query query = entityManager.createQuery(queryStr, QuestionType.class);
        List<QuestionType> questionTypeList = query.getResultList();
        return questionTypeList;
    }

    public QuestionType getQuestionTypeById(int id) {
        QuestionType QuestionType = entityManager.find(QuestionType.class, id);
        return QuestionType;
    }

    public boolean insertQuestionType(QuestionType questionType) {
        try {
            entityManager.persist(questionType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateQuestionType(QuestionType questionType) {
        try {
            entityManager.merge(questionType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeQuestionType(QuestionType questionType) {
        try {
            entityManager.remove(questionType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
