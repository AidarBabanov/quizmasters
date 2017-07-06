package kz.codemasters.quizmasters.db.DAOImpl;

import kz.codemasters.quizmasters.db.DAO.QuestionTypeDAO;
import kz.codemasters.quizmasters.model.QuestionType;
import kz.codemasters.quizmasters.model.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class QuestionTypeDAOImpl implements QuestionTypeDAO{

    EntityManager entityManager;
    public QuestionTypeDAOImpl(EntityManager entityManager){
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
