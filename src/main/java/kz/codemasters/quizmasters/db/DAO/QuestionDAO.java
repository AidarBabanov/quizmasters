package kz.codemasters.quizmasters.db.DAO;

import kz.codemasters.quizmasters.model.Question;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface QuestionDAO {
    public List<Question> getAllQuestions();

    public List<Question> getAllQuizQuistions(int quizId);

    public Question getQuestionById(int id);

    public boolean insertQuestion(Question question);

    public boolean updateQuestion(Question question);

    public boolean removeQuestion(Question question);
}
