package kz.codemasters.quizmasters.db.DAO;

import kz.codemasters.quizmasters.model.PropertyTimeToAnswer;

import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public interface PropertyTimeToAnswerDAO {
    public List<PropertyTimeToAnswer> getAllPropertyTimeToAnswers();

    public PropertyTimeToAnswer getPropertyTimeToAnswerById(int id);

    public boolean insertPropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);

    public boolean updatePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);

    public boolean removePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);
}
