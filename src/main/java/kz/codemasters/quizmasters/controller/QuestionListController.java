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
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "QtLC")
@ViewScoped
public class QuestionListController implements Serializable {

    private List<Question> questionList;
    private int quizId;

    @ManagedProperty("#{UC}")
    private
    UserController userController;
    @EJB
    private QuestionRepository questionRepository;

    @PostConstruct
    public void init(){
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (userController.getUser() == null) {
            try {
                context.redirect(context.getRequestContextPath() + "/registrationPage.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                questionList = questionRepository.getAllQuizQuistions(quizId);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
