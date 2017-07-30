package kz.codemasters.quizmasters;

import kz.codemasters.quizmasters.model.AnswerMultChoice;
import kz.codemasters.quizmasters.model.Question;
import kz.codemasters.quizmasters.model.Quiz;

import java.util.List;

public class FullQuestion {

    private Question question;
    private List<AnswerMultChoice> answerMultChoiceList;
    private int right;

    public AnswerMultChoice getRightAnswer(){
        return answerMultChoiceList.get(right);
    }


    public List<AnswerMultChoice> getAnswerMultChoiceList() {
        return answerMultChoiceList;
    }

    public void setAnswerMultChoiceList(List<AnswerMultChoice> answerMultChoiceList) {
        this.answerMultChoiceList = answerMultChoiceList;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
