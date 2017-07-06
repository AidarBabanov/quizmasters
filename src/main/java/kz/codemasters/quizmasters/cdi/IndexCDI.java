package kz.codemasters.quizmasters.cdi;

import kz.codemasters.quizmasters.db.DAO.UserDAO;
import kz.codemasters.quizmasters.db.DAOFactory;
import kz.codemasters.quizmasters.model.User;

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
    private DAOFactory daoFactory;
    private UserDAO userDAO;

    public String getUser() {
        userDAO = daoFactory.getUserDAO();
        User user = userDAO.getUserByEmail("aidar.babanov@nu.edu.kz");
        if(user==null)return "";
        else return user.getEmail();
    }

}
