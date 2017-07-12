package kz.codemasters.quizmasters.cdi;

import kz.codemasters.quizmasters.repository.interfaces.UserRepositroy;
import kz.codemasters.quizmasters.repository.RepositoryFactory;
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
    private RepositoryFactory repositoryFactory;
    //hello gittest
    private UserRepositroy userRepositroy;

    public String getUser() {
        userRepositroy = repositoryFactory.getUserRepository();
        User user = userRepositroy.getUserByEmail("aidar.babanov@nu.edu.kz");
        if(user==null)return "";
        else return user.getEmail();
    }

}
