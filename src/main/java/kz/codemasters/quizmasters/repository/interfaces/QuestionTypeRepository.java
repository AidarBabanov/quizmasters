package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.QuestionType;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuestionTypeRepository {
    public List<QuestionType> getAllQuestionTypes();

    public QuestionType getQuestionTypeById(int id);

    public boolean insertQuestionType(QuestionType questionType);

    public boolean updateQuestionType(QuestionType questionType);

    public boolean removeQuestionType(QuestionType questionType);
}
