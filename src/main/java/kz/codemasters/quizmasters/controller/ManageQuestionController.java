package kz.codemasters.quizmasters.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created by serikzhilibayev on 27.07.17.
 */


@ManagedBean(name = "MQTC")
@ViewScoped
public class ManageQuestionController {
    int quizID;


    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    @PostConstruct
    private void init(){
        quizID = Integer.parseInt(getContext().getRequestParameterMap().get("id"));
    }


    private ExternalContext getContext(){
        return FacesContext.getCurrentInstance().getExternalContext();
    }
}
