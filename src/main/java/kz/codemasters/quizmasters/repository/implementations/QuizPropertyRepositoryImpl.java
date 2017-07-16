package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuizPropertyRepository;
import kz.codemasters.quizmasters.model.QuizProperty;
import kz.codemasters.quizmasters.model.QuizPropertyPK;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
@Stateless
public class QuizPropertyRepositoryImpl implements QuizPropertyRepository {

    @PersistenceContext(name = "QuizMastersPU")
    EntityManager entityManager;

    public List<QuizProperty> getAllQuizProperties() {
        String queryStr = "SELECT a FROM QuizProperty a";
        Query query = entityManager.createQuery(queryStr, QuizProperty.class);
        return query.getResultList();
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
        try{
            return quizProperty;
        }catch (NoResultException e){
            return null;
        }
    }

    public boolean insertQuizProperty(QuizProperty quizProperty) {
        try {
            entityManager.persist(quizProperty);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean updateQuizProperty(QuizProperty quizProperty) {
        try {
            entityManager.merge(quizProperty);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean removeQuizProperty(QuizProperty quizProperty) {
        try {
            entityManager.remove(quizProperty);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
