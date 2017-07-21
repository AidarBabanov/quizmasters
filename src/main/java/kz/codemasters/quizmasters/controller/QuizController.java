package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by aidar on 7/15/17.
 */
@ManagedBean(name = "QC")
@SessionScoped
public class QuizController {

    @EJB
    private QuizRepository quizRepository;
    private List<Quiz> quizList;
    private String tempTitle;

    public void getAllUserQuizzes(int userId){
        setQuizList(quizRepository.getAllUserQuizzes(userId));
    }

    public boolean addQuiz(int userId){
        Quiz tempQuiz = new Quiz();
        tempQuiz.setName(tempTitle);
        tempQuiz.setUserId(userId);
        if(!quizRepository.insertQuiz(tempQuiz))return false;
        else{
            setQuizList(quizRepository.getAllUserQuizzes(userId));
            return true;
        }
    }

    public List<Quiz> getQuizList() {return quizList;}
    public void setQuizList(List<Quiz> quizList) {this.quizList = quizList;}
    public String getTempTitle() {return tempTitle;}
    public void setTempTitle(String tempTitle) {this.tempTitle = tempTitle;}
}
