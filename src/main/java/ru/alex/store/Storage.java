package ru.alex.store;

import ru.alex.models.User;

import java.util.Collection;

/**
 * Created by PC1 on 20.06.2017.
 */
public interface Storage {

    public Collection<User> values();

    public int add(final User user);

    public void edit(final User user);

    public void delete(final int id);

    public User get(final int id);

    public User findByLogin(final String login) ;

    public int generateId();

    public void close();
}
