package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.AnswerMultChoice;
import kz.codemasters.quizmasters.repository.interfaces.AnswerMultChoiceRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MAMCC")
@ViewScoped
public class ManageAnswerMultChoiceController {

    private AnswerMultChoice answerMultChoice;
    private int questionId;
    private int position;
    private String text;
    private byte isright;

    @EJB
    private AnswerMultChoiceRepository answerMultChoiceRepository;

    public void addAnswerMaultChoice(){
        answerMultChoice = new AnswerMultChoice();
        answerMultChoice.setIsright(isright);
        answerMultChoice.setPosition(position);
        answerMultChoice.setQuestionId(questionId);
        answerMultChoice.setText(text);
        answerMultChoiceRepository.insertAnswerMultChoice(answerMultChoice);
    }

    public void editAnswerMaultChoice(){
        answerMultChoiceRepository.updateAnswerMultChoice(answerMultChoice);
    }

    public void deleteAnswerMaultChoice(){
        answerMultChoiceRepository.removeAnswerMultChoice(answerMultChoice);
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public AnswerMultChoice getAnswerMultChoice() {
        return answerMultChoice;
    }

    public void setAnswerMultChoice(AnswerMultChoice answerMultChoice) {
        this.answerMultChoice = answerMultChoice;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte getIsright() {
        return isright;
    }

    public void setIsright(byte isright) {
        this.isright = isright;
    }
}
