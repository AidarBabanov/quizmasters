package kz.codemasters.quizmasters.db.DAO;

import kz.codemasters.quizmasters.model.QuizPropertyType;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuizPropertyTypeDAO {
    public List<QuizPropertyType> getAllQuizPropertyTypes();

    public QuizPropertyType getQuizPropertyTypeById(int id);

    public boolean insertQuizPropertyType(QuizPropertyType quizPropertyType);

    public boolean updateQuizPropertyType(QuizPropertyType quizPropertyType);

    public boolean removeQuizPropertyType(QuizPropertyType quizPropertyType);
}
