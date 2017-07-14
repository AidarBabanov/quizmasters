package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.QuestionType;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuestionTypeRepository {
    List<QuestionType> getAllQuestionTypes();

    QuestionType getQuestionTypeById(int id);

    boolean mergeQuestionType(QuestionType questionType);

    boolean removeQuestionType(QuestionType questionType);
}
