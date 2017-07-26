package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.StringsValidator;
import kz.codemasters.quizmasters.model.User;
import kz.codemasters.quizmasters.repository.interfaces.UserRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by aidar on 7/16/17.
 */
@ManagedBean(name = "SIC")
@RequestScoped
public class SignInController implements Serializable{

    private String email;
    private String password;

    @Inject
    private StringsValidator stringsValidator;
    @EJB
    private UserRepository userRepository;
    @ManagedProperty("#{UC}")
    private UserController userController;

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }


    @PostConstruct
    public void init() {
        //Have to change this part
         userController.setUser(userRepository.getUserByEmail("aidar.babanov@gmail.com"));
        //
        if (userController.getUser() != null) redirect();
    }

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
        if (user.getPassword().equals(password)) {
            userController.setUser(user);
            redirect();
            return true;
        } else return false;
    }

    private void redirect() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/mainpage.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
