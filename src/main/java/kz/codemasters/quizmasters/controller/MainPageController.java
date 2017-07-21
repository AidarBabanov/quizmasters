package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.AppConstant;
import kz.codemasters.quizmasters.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "MPC")
@SessionScoped
public class MainPageController {

    private User currentUser;//ok

    @ManagedProperty("#{QC}")
    private QuizController quizController;

    @PostConstruct
    private void init() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        setCurrentUser((User)httpSession.getAttribute(AppConstant.SESSION_USER));
        try {////Some problems here NullException is appearing for some reason (i dont know)
            quizController.getAllUserQuizzes(currentUser.getId());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public User getCurrentUser() {return currentUser;}
    public void setCurrentUser(User currentUser) {this.currentUser = currentUser;}
    public QuizController getQuizController() {return quizController;}
    public void setQuizController(QuizController quizController) {this.quizController = quizController;}

}
