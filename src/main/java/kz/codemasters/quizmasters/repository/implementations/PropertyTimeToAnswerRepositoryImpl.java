package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.PropertyTimeToAnswerRepository;
import kz.codemasters.quizmasters.model.PropertyTimeToAnswer;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
@Stateless
public class PropertyTimeToAnswerRepositoryImpl implements PropertyTimeToAnswerRepository {

    @PersistenceContext(name = "QuizMastersPU")
    EntityManager entityManager;

    public List<PropertyTimeToAnswer> getAllPropertyTimeToAnswers() {
        String queryStr = "SELECT p FROM PropertyTimeToAnswer p";
        Query query = entityManager.createQuery(queryStr, PropertyTimeToAnswer.class);
        return query.getResultList();
    }

    public PropertyTimeToAnswer getPropertyTimeToAnswerById(int id) {
        try {
            return entityManager.find(PropertyTimeToAnswer.class, id);
        } catch (NoResultException e) {
            return null;
        }

    }

    public boolean insertPropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer) {
        try {
            entityManager.persist(propertyTimeToAnswer);
            return true;
        } catch (PersistenceException e) {

            return false;
        }
    }

    public boolean updatePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer) {
        try {
            entityManager.merge(propertyTimeToAnswer);
            return true;
        } catch (PersistenceException e) {

            return false;
        }
    }

    public boolean removePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer) {
        try {
            entityManager.remove(propertyTimeToAnswer);
            return true;
        } catch (PersistenceException e) {

            return false;
        }
    }
}
