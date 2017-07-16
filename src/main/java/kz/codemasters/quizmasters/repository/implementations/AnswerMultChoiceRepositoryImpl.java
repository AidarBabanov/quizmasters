package kz.codemasters.quizmasters.repository.implementations;


import kz.codemasters.quizmasters.repository.interfaces.AnswerMultChoiceRepository;
import kz.codemasters.quizmasters.model.AnswerMultChoice;
import kz.codemasters.quizmasters.model.AnswerMultChoicePK;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
@Stateless
public class AnswerMultChoiceRepositoryImpl implements AnswerMultChoiceRepository {

    @PersistenceContext(name = "QuizMastersPU")
    EntityManager entityManager;

    public List<AnswerMultChoice> getAllAnswerMultChoices() {
        String queryStr = "SELECT a FROM AnswerMultChoice a";
        Query query = entityManager.createQuery(queryStr, AnswerMultChoice.class);
        return query.getResultList();
    }

    public List<AnswerMultChoice> getAllQuestionAnswerMultChoices(int questionId) {
        String queryStr = "SELECT a FROM AnswerMultChoice a WHERE a.questionId = :questionId";
        Query query = entityManager.createQuery(queryStr, AnswerMultChoice.class)
                .setParameter("questionId", questionId);
        return query.getResultList();
    }

    public AnswerMultChoice getAnswerMultChoiceByCompositeKey(int questionId, int position) {
        AnswerMultChoicePK answerMultChoicePK = new AnswerMultChoicePK();
        answerMultChoicePK.setQuestionId(questionId);
        answerMultChoicePK.setPosition(position);
        try {
            return entityManager.find(AnswerMultChoice.class, answerMultChoicePK);
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean insertAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        try {
            entityManager.persist(answerMultChoice);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean updateAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        try {
            entityManager.merge(answerMultChoice);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean removeAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        try {
            entityManager.remove(answerMultChoice);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
