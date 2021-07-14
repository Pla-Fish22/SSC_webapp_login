package io.muzoo.ooc.webapp.basic.servlets;

import io.muzoo.ooc.webapp.basic.security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeServlet extends AbstractRoutableHttpServlet{
    @Override
    public String getPattern() {
        return "/change";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(securityService.isAuthorized(request)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/password.jsp");
            requestDispatcher.include(request, response);
        }
        else{
            response.sendRedirect("/login");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String username = (String) request.getSession().getAttribute("username");
        new UserService().editPassword(username, password);
        response.sendRedirect("/");
    }
}
