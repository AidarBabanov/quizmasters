package cdi;

import db.DAOImpl.UserDAOImpl;
import db.model.User;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Alexandr on 20.06.2017.
 */
@Named
@SessionScoped
public class IndexCDI implements Serializable {

    @EJB
    private UserDAOImpl indexEJB;

    public String getUser() {
        User user = indexEJB.getUserByEmail("aidar.babanov@nu.edu.kz");
        if(user==null)return "";
        else return user.getEmail();
    }

}
