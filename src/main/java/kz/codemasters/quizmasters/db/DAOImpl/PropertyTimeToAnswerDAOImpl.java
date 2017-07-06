package kz.codemasters.quizmasters.db.DAOImpl;

import kz.codemasters.quizmasters.db.DAO.PropertyTimeToAnswerDAO;
import kz.codemasters.quizmasters.model.PropertyTimeToAnswer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class PropertyTimeToAnswerDAOImpl implements PropertyTimeToAnswerDAO {

    EntityManager entityManager;
    public PropertyTimeToAnswerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<PropertyTimeToAnswer> getAllPropertyTimeToAnswers() {
        String queryStr = "SELECT p FROM PropertyTimeToAnswer p";
        Query query = entityManager.createQuery(queryStr, PropertyTimeToAnswer.class);
        List<PropertyTimeToAnswer> propertyTimeToAnswerList = query.getResultList();
        return propertyTimeToAnswerList;
    }

    public PropertyTimeToAnswer getPropertyTimeToAnswerById(int id) {
        PropertyTimeToAnswer PropertyTimeToAnswer = entityManager.find(PropertyTimeToAnswer.class, id);
        return PropertyTimeToAnswer;
    }

    public boolean insertPropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer) {
        try {
            entityManager.persist(propertyTimeToAnswer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updatePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer) {
        try {
            entityManager.merge(propertyTimeToAnswer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer) {
        try {
            entityManager.remove(propertyTimeToAnswer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
