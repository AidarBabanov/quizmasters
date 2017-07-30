package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.FullQuestion;
import kz.codemasters.quizmasters.model.AnswerMultChoice;
import kz.codemasters.quizmasters.model.Question;
import kz.codemasters.quizmasters.model.Quiz;
import kz.codemasters.quizmasters.repository.interfaces.AnswerMultChoiceRepository;
import kz.codemasters.quizmasters.repository.interfaces.QuestionRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "QtLC")
@ViewScoped
public class QuestionListController implements Serializable {


    private Quiz quiz;
    private List<FullQuestion> fullQuestionList;
    private FullQuestion tempFullQuestion;

    @ManagedProperty("#{UC}")
    private UserController userController;
    @EJB
    private QuestionRepository questionRepository;
    @EJB
    private AnswerMultChoiceRepository answerMultChoiceRepository;

    @PostConstruct
    public void init() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (userController.getUser() == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/registrationPage.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<Question> questionList = questionRepository.getAllQuizQuistions(quiz.getId());
                for(Question question: questionList){
                    FullQuestion fullQuestion = new FullQuestion();
                    fullQuestion.setQuestion(question);
                    fullQuestion.setAnswerMultChoiceList(answerMultChoiceRepository.getAllQuestionAnswerMultChoices(question.getId()));
                    fullQuestionList.add(fullQuestion);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void addQuestion(){

    }


    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public UserController getUserController() {
        return userController;
    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    public List<FullQuestion> getFullQuestionList() {
        return fullQuestionList;
    }

    public void setFullQuestionList(List<FullQuestion> fullQuestionList) {
        this.fullQuestionList = fullQuestionList;
    }

    public AnswerMultChoiceRepository getAnswerMultChoiceRepository() {
        return answerMultChoiceRepository;
    }

    public void setAnswerMultChoiceRepository(AnswerMultChoiceRepository answerMultChoiceRepository) {
        this.answerMultChoiceRepository = answerMultChoiceRepository;
    }


    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public FullQuestion getTempFullQuestion() {
        return tempFullQuestion;
    }

    public void setTempFullQuestion(FullQuestion tempFullQuestion) {
        this.tempFullQuestion = tempFullQuestion;
    }
}
