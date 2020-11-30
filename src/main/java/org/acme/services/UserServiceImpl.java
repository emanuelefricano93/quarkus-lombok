package org.acme.services;

import org.acme.bom.User;
import org.acme.storage.MongoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    MongoService mongoService;

    @Override
    public User getUserByName(String name) {
        return mongoService.getUserByName(name);
    }

    @Override
    public List<User> getUsers() {
        return mongoService.getUsers();
    }

    @Override
    public User addUser(User user) {
        return mongoService.addUser(user);
    }
}
