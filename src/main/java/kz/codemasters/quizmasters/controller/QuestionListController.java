package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.Question;
import kz.codemasters.quizmasters.repository.interfaces.QuestionRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "QtLC")
@RequestScoped
public class QuestionListController implements Serializable {

    private int quizId;
    private List<Question> questionList;

    @ManagedProperty("#{UC}")
    private UserController userController;
    @EJB
    private QuestionRepository questionRepository;

    public List<Question> getQuestionList() {
        questionList = questionRepository.getAllQuizQuistions(quizId);
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }


}
