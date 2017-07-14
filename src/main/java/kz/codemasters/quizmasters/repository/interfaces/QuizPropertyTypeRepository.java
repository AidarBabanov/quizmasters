package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.QuizPropertyType;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuizPropertyTypeRepository {
    List<QuizPropertyType> getAllQuizPropertyTypes();

    QuizPropertyType getQuizPropertyTypeById(int id);

    boolean mergeQuizPropertyType(QuizPropertyType quizPropertyType);

    boolean removeQuizPropertyType(QuizPropertyType quizPropertyType);
}
