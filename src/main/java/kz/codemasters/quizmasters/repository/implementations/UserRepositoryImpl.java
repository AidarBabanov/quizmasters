package kz.codemasters.quizmasters.repository.implementations;

import kz.codemasters.quizmasters.repository.interfaces.UserRepository;
import kz.codemasters.quizmasters.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Alexandr on 20.06.2017.
 */
@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(name = "QuizMastersPU")
    private EntityManager entityManager;


    public List<User> getAllUsers() {
        String queryStr = "SELECT u FROM User u";
        Query query = entityManager.createQuery(queryStr, User.class);
        List<User> userList = query.getResultList();
        return userList;
    }

    public User getUserById(int id) {
        try {
            return entityManager.find(User.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    public User getUserByEmail(String email) {
        if(email==null)return null;
        email = email.trim().toLowerCase();
        String queryStr = "SELECT u FROM User u WHERE u.email =:email";
        Query query = entityManager.createQuery(queryStr, User.class)
                .setParameter("email", email);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean mergeUser(User user) {
        try {
            entityManager.merge(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeUser(User user) {
        try {
            entityManager.remove(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
