package ru.alex.servlets;

import ru.alex.models.User;
import ru.alex.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by PC1 on 19.06.2017.
 */
public class UserEditServlet extends HttpServlet {

//    final AtomicInteger ids = new AtomicInteger();
    private static int ID = 0;

    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ID = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("user", USER_CACHE.get(ID));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CACHE.edit(new User(ID, req.getParameter("login"), req.getParameter("email")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
