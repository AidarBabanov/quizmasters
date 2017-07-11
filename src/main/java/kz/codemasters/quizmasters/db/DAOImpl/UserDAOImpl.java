package kz.codemasters.quizmasters.db.DAOImpl;

import kz.codemasters.quizmasters.db.DAO.UserDAO;
import kz.codemasters.quizmasters.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Alexandr on 20.06.2017.
 */

public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        String queryStr = "SELECT u FROM User u";
        Query query = entityManager.createQuery(queryStr, User.class);
        List<User> userList = query.getResultList();
        return userList;
    }

    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public User getUserByEmail(String email) {
        String queryStr = "SELECT u FROM User u WHERE u.email =:email";
        Query query = entityManager.createQuery(queryStr, User.class)
                .setParameter("email", email);
        User user = (User) query.getSingleResult();
        return user;
    }

    public boolean insertUser(User user) {
        try {
            entityManager.persist(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateUser(User user) {
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
