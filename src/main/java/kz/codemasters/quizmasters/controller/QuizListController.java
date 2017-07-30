package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "QLC")
@RequestScoped
public class QuizListController implements Serializable {

    private List<Quiz> quizList;

    @EJB
    private QuizRepository quizRepository;
    @ManagedProperty("#{UC}")
    private UserController userController;

    @PostConstruct
    private void init() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (userController.getUser() == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/registrationPage.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                quizList = quizRepository.getAllUserQuizzes(userController.getUser().getId());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

}
