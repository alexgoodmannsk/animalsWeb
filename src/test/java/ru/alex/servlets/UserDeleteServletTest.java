package ru.alex.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.alex.models.User;
import ru.alex.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by PC1 on 19.06.2017.
 */
public class UserDeleteServletTest extends Mockito{
    final UserCache cache = UserCache.getInstance();
    @Test
    public void deleteUser() throws ServletException, IOException {
        //создаем заглушки запроса и ответа для метода doGet
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //проверяем пустое ли хранилище при создании
        int sizeBefore = cache.values().size();
        //создаем в хранилище юзера
        String idB = String.valueOf(cache.add(new User(1,"test","test")));
        //проверяем что в хранилище появился юзер
        assertEquals(sizeBefore+1, cache.values().size());

        //устанавливаем требуемое значение id при вызове в запросе getParameter
        when(request.getParameter("id")).thenReturn(idB);

        //делаем тестируемый вызов doGet
        new UserDeleteServlet().doGet(request, response);

        //проверяем что хотябы раз был совершен тестируемый вызов
        verify(request, atLeast(1)).getParameter("id");

        //проверяем удалился ли нужный пользователь из базы
        assertEquals(sizeBefore, cache.values().size());

    }
}