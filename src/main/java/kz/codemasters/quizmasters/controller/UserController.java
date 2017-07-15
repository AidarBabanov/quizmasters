package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.EmailValidator;
import kz.codemasters.quizmasters.model.User;
import kz.codemasters.quizmasters.repository.interfaces.UserRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 * Created by aidar on 7/15/17.
 */
@ManagedBean
@SessionScoped
public class UserController {

    @EJB
    private UserRepository userRepository;
    private User user = new User();
    private String regPassword2 = "";

    private EmailValidator emailValidator = new EmailValidator();

    public String getRegPassword2() {
        return regPassword2;
    }

    public void setRegPassword2(String regPassword2) {
        this.regPassword2 = regPassword2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean signUp() {
        return userRepository.getUserByEmail(user.getEmail()) == null && userRepository.insertUser(user);
    }

    public boolean signIn(String email, String password) {
        user = userRepository.getUserByEmail(email);
        return !(user == null || !user.getPassword().equals(password));
    }

    public boolean change() {
        return userRepository.updateUser(user);
    }


}
