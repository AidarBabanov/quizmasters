package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.QuizPropertyTypeRepository;
import kz.codemasters.quizmasters.model.QuizPropertyType;

import javax.ejb.Stateless;
import javax.persistence.*;
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

    public boolean insertQuizPropertyType(QuizPropertyType quizPropertyType) {
        try {
            entityManager.persist(quizPropertyType);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean updateQuizPropertyType(QuizPropertyType quizPropertyType) {
        try {
            entityManager.merge(quizPropertyType);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean removeQuizPropertyType(QuizPropertyType quizPropertyType) {
        try {
            entityManager.remove(quizPropertyType);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
