package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.AnswerMultChoice;

import java.util.List;

/**
 * Created by aidar on 7/5/17.
 */
public interface AnswerMultChoiceRepository {

    List<AnswerMultChoice> getAllAnswerMultChoices();

    List<AnswerMultChoice> getAllQuestionAnswerMultChoices(int questionId);

    AnswerMultChoice getAnswerMultChoiceByCompositeKey(int questionId, int position);

    boolean insertAnswerMultChoice(AnswerMultChoice answerMultChoice);

    boolean updateAnswerMultChoice(AnswerMultChoice answerMultChoice);

    boolean removeAnswerMultChoice(AnswerMultChoice answerMultChoice);
}
