package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Question;
import kz.codemasters.quizmasters.repository.interfaces.QuestionRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created by serikzhilibayev on 27.07.17.
 */


@ManagedBean(name = "MQtC")
@ViewScoped
public class ManageQuestionController {
    private Question question;
    private int quizId;
    private int questionTypeId;
    private String text;

    @EJB
    private QuestionRepository questionRepository;

    public void addQuestion(){
        question = new Question();
        question.setQuizId(quizId);
        question.setQuestionTypeId(1);
        question.setText(text);
        questionRepository.insertQuestion(question);
    }

    public void editQuestion(){
        questionRepository.updateQuestion(question);
    }

    public void deleteQuestion(){
        questionRepository.removeQuestion(question);
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
//    @PostConstruct
//    private void init(){
//        quizID = Integer.parseInt(getContext().getRequestParameterMap().get("id"));
//    }
//
//    private ExternalContext getContext(){
//        return FacesContext.getCurrentInstance().getExternalContext();
//    }



}
