package db.DAOImpl;

import db.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Alexandr on 20.06.2017.
 */
public class UserDAOImpl {


    private EntityManager entityManager;

    UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public User getUserByEmail(String email){
        String queryStr = "SELECT u FROM User u WHERE u.email =:email";
        Query query = entityManager.createQuery(queryStr, User.class)
                .setParameter("email", email);
        User user = (User) query.getSingleResult();
        return user;
    }

    public User getUserById(int id){
        User user = entityManager.find(User.class, id);
        return user;
    }

//    public boolean setUser(String email, String firstname, String lastname){
//
//    }

}
