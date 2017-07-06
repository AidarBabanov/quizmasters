package kz.codemasters.quizmasters.db.DAO;

import kz.codemasters.quizmasters.model.User;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface UserDAO {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public User getUserByEmail(String email);

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    public boolean removeUser(User user);
}
