package ru.alex.store;

import ru.alex.models.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by PC1 on 19.06.2017.
 */
public class UserCache implements Storage {
    private static final UserCache INSTANCE = new UserCache();

    private final Storage storage = new MemoryStorage();

    public static UserCache getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<User> values() {
        return storage.values();
    }

    @Override
    public int add(final User user) {
        return this.storage.add(user);
    }

    @Override
    public void edit(final User user) {
        this.storage.edit(user);
    }

    @Override
    public void delete(final int id) {
        this.storage.delete(id);
    }

    @Override
    public User get(final int id) {
        return this.storage.get(id);
    }

    @Override
    public User findByLogin(final String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }
}

