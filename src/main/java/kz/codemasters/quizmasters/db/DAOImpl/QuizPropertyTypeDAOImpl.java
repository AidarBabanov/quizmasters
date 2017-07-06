package kz.codemasters.quizmasters.db.DAOImpl;

import kz.codemasters.quizmasters.db.DAO.QuizPropertyTypeDAO;
import kz.codemasters.quizmasters.model.QuizPropertyType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class QuizPropertyTypeDAOImpl implements QuizPropertyTypeDAO {

    EntityManager entityManager;

    public QuizPropertyTypeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<QuizPropertyType> getAllQuizPropertyTypes() {
        String queryStr = "SELECT q FROM QuizPropertyType q";
        Query query = entityManager.createQuery(queryStr, QuizPropertyType.class);
        List<QuizPropertyType> quizPropertyTypeList = query.getResultList();
        return quizPropertyTypeList;
    }

    public QuizPropertyType getQuizPropertyTypeById(int id) {
        QuizPropertyType quizPropertyType = entityManager.find(QuizPropertyType.class, id);
        return quizPropertyType;
    }

    public boolean insertQuizPropertyType(QuizPropertyType quizPropertyType) {
        try {
            entityManager.persist(quizPropertyType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateQuizPropertyType(QuizPropertyType quizPropertyType) {
        try {
            entityManager.merge(quizPropertyType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeQuizPropertyType(QuizPropertyType quizPropertyType) {
        try {
            entityManager.remove(quizPropertyType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
