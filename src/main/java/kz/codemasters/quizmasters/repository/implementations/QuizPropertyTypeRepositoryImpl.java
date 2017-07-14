package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuizPropertyTypeRepository;
import kz.codemasters.quizmasters.model.QuizPropertyType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
@Stateless
public class QuizPropertyTypeRepositoryImpl implements QuizPropertyTypeRepository {

    @PersistenceContext(name = "QuizMastersPU")
    EntityManager entityManager;

    public List<QuizPropertyType> getAllQuizPropertyTypes() {
        String queryStr = "SELECT q FROM QuizPropertyType q";
        Query query = entityManager.createQuery(queryStr, QuizPropertyType.class);
        return query.getResultList();
    }

    public QuizPropertyType getQuizPropertyTypeById(int id) {
        try {
            return entityManager.find(QuizPropertyType.class, id);
        }catch (NoResultException e){
            return null;
        }

    }

    public boolean mergeQuizPropertyType(QuizPropertyType quizPropertyType) {
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
