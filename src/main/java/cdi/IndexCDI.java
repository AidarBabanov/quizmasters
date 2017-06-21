package cdi;

import ejb.IndexEJB;

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

    private int id = 1;
    private String username;

    @EJB
    private IndexEJB indexEJB;

    public String getUser() {
        String s = indexEJB.getUser(id);
        System.out.println("Test CDI");
        return s;
    }

}
