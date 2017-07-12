package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.AnswerMultChoice;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface AnswerMultChoiceRepository {

    public List<AnswerMultChoice> getAllAnswerMultChoices();

    public List<AnswerMultChoice> getAllQuestionAnswerMultChoices(int questionId);

    public AnswerMultChoice getAnswerMultChoiceByCompositeKey(int questionId, int position);

    public boolean insertAnswerMultChoice(AnswerMultChoice answerMultChoice);

    public boolean updateAnswerMultChoice(AnswerMultChoice answerMultChoice);

    public boolean removeAnswerMultChoice(AnswerMultChoice answerMultChoice);
}
