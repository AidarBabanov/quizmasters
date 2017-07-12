package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.User;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface UserRepositroy {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public User getUserByEmail(String email);

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    public boolean removeUser(User user);
}
