package kz.codemasters.quizmasters.controller;

import kz.codemasters.quizmasters.repository.interfaces.UserRepository;
import kz.codemasters.quizmasters.model.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Alexandr on 20.06.2017.
 */

@ManagedBean
@RequestScoped
public class IndexCDI implements Serializable {

    @EJB
    private UserRepository userRepository;

    public String getUser() {
        User user = userRepository.getUserByEmail("aidar.babanov@nu.edu.kz");
        if(user==null)return "777";
        else return user.getEmail();
    }

}
