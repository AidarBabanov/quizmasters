package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.PropertyTimeToAnswer;

import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public interface PropertyTimeToAnswerRepository {
    List<PropertyTimeToAnswer> getAllPropertyTimeToAnswers();

    PropertyTimeToAnswer getPropertyTimeToAnswerById(int id);

    boolean insertPropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);

    boolean updatePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);

    boolean removePropertyTimeToAnswer(PropertyTimeToAnswer propertyTimeToAnswer);
}
