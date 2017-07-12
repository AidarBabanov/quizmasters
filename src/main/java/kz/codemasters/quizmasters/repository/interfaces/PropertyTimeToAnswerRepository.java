package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.PropertyTimeToAnswer;

import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public interface PropertyTimeToAnswerRepository {
    public List<PropertyTimeToAnswer> getAllPropertyTimeToAnswers();

    public PropertyTimeToAnswer getPropertyTimeToAnswerById(int id);

    public boolean insertPropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);

    public boolean updatePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);

    public boolean removePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);
}
