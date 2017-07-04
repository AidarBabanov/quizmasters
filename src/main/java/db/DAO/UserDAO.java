package db.DAO;

import db.model.User;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface UserDAO {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public User getUserByEmail(String email);

    public boolean insertUser(String email, String firstname, String lastname, String password);

    public boolean updateUser(int id, String email, String firstname, String lastname, String password);

    public boolean removeUser(int id);
}
