package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by aidar on 7/15/17.
 */
@ManagedBean
@SessionScoped
public class QuizController {

    @EJB
    private QuizRepository quizRepository;
    private List<Quiz> quizList;
    private Quiz tempQuiz;

    public List<Quiz> getAllUserQuizzes(int userId){
        quizList = quizRepository.getAllUserQuizzes(userId);
        return quizList;
    }

    public boolean addQuiz(int userId){
        if(!quizRepository.insertQuiz(tempQuiz))return false;
        else{
            quizList = quizRepository.getAllUserQuizzes(userId);
            return true;
        }
    }

}
