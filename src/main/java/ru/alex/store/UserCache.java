package ru.alex.store;

import ru.alex.models.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by PC1 on 19.06.2017.
 */
public class UserCache{
    private static final UserCache INSTANCE = new UserCache();

    private final ConcurrentHashMap<Integer,User> users = new ConcurrentHashMap<Integer, User>();

    public static UserCache getInstance() {
        return INSTANCE;
    }

    public Collection<User> values() {
        return INSTANCE.users.values();
    }

    public int add(final User user) {
        users.put(user.getId(),user);
        return  user.getId();
    }

    public void edit(final User user) {this.users.replace(user.getId(),user);}

    public void delete(final int id) {this.users.remove(id);}

    public User get(final int id){return this.users.get(id);}

    public int generateId(){
        int id = 0;
        while (users.containsKey(id)){
            id++;
        }
        return id;
    }

    public User findByLogin(final String login){
        for (final User user : users.values()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new IllegalStateException(String.format("Login %s not found", login));
    }
}
