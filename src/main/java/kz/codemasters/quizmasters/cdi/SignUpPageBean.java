package kz.codemasters.quizmasters.cdi;
/**
 * Created by serikzhilibayev on 12.07.17.
 */
import kz.codemasters.quizmasters.model.User;
import kz.codemasters.quizmasters.repository.interfaces.UserRepository;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name = "spb")
@RequestScoped
public class SignUpPageBean {
    private String fname;
    private String lname;
    private String password1;
    private String password2;
    private String email;

    @EJB
    private UserRepository userRepository;

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
        if (userRepository.getUserByEmail(email) == null){
            User user = new User();
            user.setEmail(getEmail());
            user.setFirstname(getFname());
            user.setLastname(getLname());
            user.setPassword(getPassword1());
            userRepository.mergeUser(user);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registered!"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Try Again...", "Already Registered!"));
        }
    }
}
