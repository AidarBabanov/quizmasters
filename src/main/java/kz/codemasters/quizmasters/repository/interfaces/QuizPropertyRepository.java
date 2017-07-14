package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.QuizProperty;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuizPropertyRepository {
    List<QuizProperty> getAllQuizProperties();

    List<QuizProperty> getAllQuizQuizProperties(int quizId);

    QuizProperty getQuizPropertyByCompositeKey(int quizId, int quizPropertyTypeId);

    boolean mergeQuizProperty(QuizProperty quizProperty);

    boolean removeQuizProperty(QuizProperty quizProperty);
}
