package ru.alex.servlets;

import ru.alex.models.User;
import ru.alex.store.JdbcStorage;
import ru.alex.store.Storage;
import ru.alex.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by PC1 on 19.06.2017.
 */
public class UserViewServlet extends HttpServlet {

    private UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", USER_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        USER_CACHE.close();
    }
}
