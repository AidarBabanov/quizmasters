package kz.codemasters.quizmasters.db.DAO;

import kz.codemasters.quizmasters.model.QuizProperty;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuizPropertyDAO {
    public List<QuizProperty> getAllQuizProperties();

    public List<QuizProperty> getAllQuizQuizProperties(int quizId);

    public QuizProperty getQuizPropertyByCompositeKey(int quizId, int quizPropertyTypeId);

    public boolean insertQuizProperty(QuizProperty quizProperty);

    public boolean updateQuizProperty(QuizProperty quizProperty);

    public boolean removeQuizProperty(QuizProperty quizProperty);
}
