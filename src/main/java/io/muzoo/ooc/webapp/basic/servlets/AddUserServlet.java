package io.muzoo.ooc.webapp.basic.servlets;

import io.muzoo.ooc.webapp.basic.security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(securityService.isAuthorized(request)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/addUser.jsp");
            requestDispatcher.include(request, response);
        }
        else{
            response.sendRedirect("/login");
        }
    }

    @Override
    public String getPattern() {
        return "/addUser";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;
        String username = request.getParameter("newUserName");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        UserService userService = new UserService();
        if(userService.checkIfUserExists(username)){
            error = "This username is already existed";
            request.setAttribute("error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/addUser.jsp");
            requestDispatcher.include(request, response);
        }
        else{
            userService.createUser(username,password,firstname,lastname);
            response.sendRedirect("/");
        }

    }
}
