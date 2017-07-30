package kz.codemasters.quizmasters.controller;


import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;


@ManagedBean(name = "MQC")
@ViewScoped
public class ManageQuizController {

    private Quiz quiz;
    private String title;


    @ManagedProperty("#{UC}")
    private UserController userController;

    @EJB
    private QuizRepository quizRepository;


    public boolean addQuiz() {
        Quiz quiz = new Quiz();
        quiz.setName(title);
        quiz.setUserId(userController.getUser().getId());
        return quizRepository.insertQuiz(quiz);

    }

    public boolean renameQuiz() {
        return quiz.getUserId() == userController.getUser().getId() &&
                quizRepository.updateQuiz(quiz);
    }

    public void deleteQuiz() {
        int ucUserId = userController.getUser().getId();
        int quizUserId = quiz.getUserId();
        if (quizUserId != ucUserId) return;
        quizRepository.removeQuiz(quiz);
    }

    public void viewQuestions(){
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect(context.getRequestContextPath() + "/questions.xhtml?id="+quiz.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

}
