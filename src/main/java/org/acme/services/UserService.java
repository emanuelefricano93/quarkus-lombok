package org.acme.services;

import org.acme.bom.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

public interface UserService {

    User getUserByName(String name);

    List<User> getUsers();

    User addUser(User user);
}
