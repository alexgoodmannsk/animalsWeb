package ru.alex.store;

import org.junit.Test;
import ru.alex.models.User;
import ru.alex.services.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PC1 on 20.06.2017.
 */
public class JdbcStorageTest {

    @Test
    public void addUserTest(){
        final JdbcStorage storage = new JdbcStorage();
        final int id = storage.add(new User(-1,"test","12341234"));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
        storage.close();
    }

    @Test
    public void deleteUserTest(){
        final JdbcStorage storage = new JdbcStorage();
        final int id = storage.add(new User(-1,"test2","12341234"));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
        int sizeBefore = storage.values().size();
        storage.delete(id);
        int sizeAfter = storage.values().size();
        assertEquals(sizeAfter+1,sizeBefore);
        storage.close();
    }


}



