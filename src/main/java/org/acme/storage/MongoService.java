package org.acme.storage;

import com.mongodb.*;
import org.acme.bom.User;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MongoService {

    private MongoClient client;

    public MongoService() throws UnknownHostException {
        System.out.println("Mongo Service constructor");
        client = new MongoClient("localhost");
    }

    public User getUserByName(String name) {
        DB db = client.getDB("db_test");
        DBCollection users = db.getCollection("users");
        //DBObject user = users.find().one();
        BasicDBObject query = new BasicDBObject();
        query.put("name", new BasicDBObject("$eq", name));
        DBObject user = users.find(query).one();
        return new User(user);
    }

    public List<User> getUsers() {
        List<User> usersList = new ArrayList<>();
        DB db = client.getDB("db_test");
        DBCollection users = db.getCollection("users");
        DBCursor cursor = users.find();
        while (cursor.hasNext()) {
            //DBObject obj = cursor.next();
            usersList.add(new User(cursor.next()));
        }
        return usersList;
    }

    public User addUser(User user) {
        DB db = client.getDB("db_test");
        DBCollection users = db.getCollection("users");
        DBObject userObj = new BasicDBObject();
        userObj.put("name", user.getName());
        userObj.put("lastname", user.getLastname());
        userObj.put("age", user.getAge());
        users.insert(userObj);
        return new User(userObj);
    }
}
