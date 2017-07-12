package kz.codemasters.quizmasters.cdi;
/**
 * Created by serikzhilibayev on 12.07.17.
 */
import kz.codemasters.quizmasters.db.DAO.UserDAO;
import kz.codemasters.quizmasters.db.DAOFactory;
import kz.codemasters.quizmasters.model.User;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean(name = "rpb")
@SessionScoped
public class registrationPageBean {
    String fname;
    String lname;
    String password1;
    String password2;
    @EJB
    private DAOFactory daoFactory;

    private UserDAO userDAO;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    String email;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void save() {
        userDAO = daoFactory.getUserDAO();
        if (userDAO.getUserByEmail(email) == null){

            userDAO.updateUser(new User());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registered!"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Try Again...", "Already Registered!"));
        }
    }
}
