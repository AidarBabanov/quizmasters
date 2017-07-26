package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UC")
@SessionScoped
public class UserController {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
