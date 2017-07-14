package kz.codemasters.quizmasters.repository.interfaces;

import kz.codemasters.quizmasters.model.User;

import java.util.List;

/**
 * Created by aidar on 7/4/17.
 */
public interface UserRepository {

    List<User> getAllUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

    boolean mergeUser(User user);

    boolean removeUser(User user);
}
