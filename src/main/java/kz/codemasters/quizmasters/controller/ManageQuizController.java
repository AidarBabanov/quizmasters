package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.QuizRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "MQC")
@RequestScoped
public class ManageQuizController {

    private int id;
    private String title;

    @ManagedProperty("#{UC}")
    private UserController userController;

    @EJB
    private QuizRepository quizRepository;

    public QuizRepository getQuizRepository() {
        return quizRepository;
    }

    public void setQuizRepository(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean addQuiz(){
        Quiz quiz = new Quiz();
        quiz.setName(title);
        quiz.setUserId(userController.getUser().getId());
        return quizRepository.insertQuiz(quiz);

    }

    public boolean editQuiz() {
        Quiz quiz = quizRepository.getQuizById(id);
        return quiz.getUserId() == userController.getUser().getId() &&
                quizRepository.updateQuiz(quiz);
    }

    public boolean deleteQuiz(){
        Quiz quiz = quizRepository.getQuizById(id);
        return quiz.getUserId() == userController.getUser().getId() &&
                quizRepository.removeQuiz(quiz);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
