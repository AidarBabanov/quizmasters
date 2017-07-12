package kz.codemasters.quizmasters.repository.implementations;


import kz.codemasters.quizmasters.repository.interfaces.AnswerMultChoiceRepository;
import kz.codemasters.quizmasters.model.AnswerMultChoice;
import kz.codemasters.quizmasters.model.AnswerMultChoicePK;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aidar on 7/6/17.
 */
public class AnswerMultChoiceRepositoryImpl implements AnswerMultChoiceRepository {

    EntityManager entityManager;

    public AnswerMultChoiceRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<AnswerMultChoice> getAllAnswerMultChoices() {
        String queryStr = "SELECT a FROM AnswerMultChoice a";
        Query query = entityManager.createQuery(queryStr, AnswerMultChoice.class);
        List<AnswerMultChoice> answerMultChoiceList = query.getResultList();
        return answerMultChoiceList;
    }

    public List<AnswerMultChoice> getAllQuestionAnswerMultChoices(int questionId) {
        String queryStr = "SELECT a FROM AnswerMultChoice a WHERE a.questionId = :questionId";
        Query query = entityManager.createQuery(queryStr, AnswerMultChoice.class)
                .setParameter("questionId", questionId);
        List<AnswerMultChoice> answerMultChoiceList = query.getResultList();
        return answerMultChoiceList;
    }

    public AnswerMultChoice getAnswerMultChoiceByCompositeKey(int questionId, int position) {
        AnswerMultChoicePK answerMultChoicePK = new AnswerMultChoicePK();
        answerMultChoicePK.setQuestionId(questionId);
        answerMultChoicePK.setPosition(position);
        AnswerMultChoice answerMultChoice = entityManager.find(AnswerMultChoice.class, answerMultChoicePK);
        return answerMultChoice;
    }

    public boolean insertAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        try {
            entityManager.persist(answerMultChoice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        try {
            entityManager.merge(answerMultChoice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        try {
            entityManager.remove(answerMultChoice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
