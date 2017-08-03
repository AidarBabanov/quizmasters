package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.AnswerMultChoice;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "AMCLC")
@ViewScoped
public class AnswerMultChoiceListController implements Serializable {

    private int questionId;
    private List<AnswerMultChoice> answerMultChoiceList;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public List<AnswerMultChoice> getAnswerMultChoiceList() {
        return answerMultChoiceList;
    }

    public void setAnswerMultChoiceList(List<AnswerMultChoice> answerMultChoiceList) {
        this.answerMultChoiceList = answerMultChoiceList;
    }
}
