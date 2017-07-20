package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.AppConstant;
import kz.codemasters.quizmasters.StringsValidator;
import kz.codemasters.quizmasters.model.User;
import kz.codemasters.quizmasters.repository.interfaces.UserRepository;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Created by aidar on 7/16/17.
 */
@ManagedBean(name = "SIC")
@RequestScoped
public class SignInController {

    private String email;
    private String password;
    @Inject
    StringsValidator stringsValidator;
    @EJB
    UserRepository userRepository;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean SignIn() {
        if (!stringsValidator.validateEmail(email, FacesContext.getCurrentInstance())) return false;
        User user = userRepository.getUserByEmail(email);
        if(user.getPassword().equals(password)){
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute(AppConstant.SESSION_USER, user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"OK", " " + ((User) httpSession.getAttribute(AppConstant.SESSION_USER))));
            return true;
        }
        else return false;
    }
}
