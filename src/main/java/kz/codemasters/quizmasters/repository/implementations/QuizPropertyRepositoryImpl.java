package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuizPropertyRepository;
import kz.codemasters.quizmasters.model.QuizProperty;
import kz.codemasters.quizmasters.model.QuizPropertyPK;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class QuizPropertyRepositoryImpl implements QuizPropertyRepository {

    EntityManager entityManager;
    public QuizPropertyRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<QuizProperty> getAllQuizProperties() {
        String queryStr = "SELECT a FROM QuizProperty a";
        Query query = entityManager.createQuery(queryStr, QuizProperty.class);
        List<QuizProperty> quizPropertyList = query.getResultList();
        return quizPropertyList;
    }

    public List<QuizProperty> getAllQuizQuizProperties(int quizId) {
        String queryStr = "SELECT a FROM QuizProperty a WHERE a.quizId = :quizId";
        Query query = entityManager.createQuery(queryStr, QuizProperty.class)
                .setParameter("quizId", quizId);
        List<QuizProperty> quizPropertyList = query.getResultList();
        return quizPropertyList;
    }

    public QuizProperty getQuizPropertyByCompositeKey(int quizId, int quizPropertyTypeId) {
        QuizPropertyPK quizPropertyPK = new QuizPropertyPK();
        quizPropertyPK.setQuizId(quizId);
        quizPropertyPK.setQuizPropertyTypeId(quizPropertyTypeId);
        QuizProperty quizProperty = entityManager.find(QuizProperty.class, quizPropertyPK);
        return quizProperty;
    }


    public boolean insertQuizProperty(QuizProperty quizProperty) {
        try {
            entityManager.persist(quizProperty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateQuizProperty(QuizProperty quizProperty) {
        try {
            entityManager.merge(quizProperty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeQuizProperty(QuizProperty quizProperty) {
        try {
            entityManager.remove(quizProperty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
