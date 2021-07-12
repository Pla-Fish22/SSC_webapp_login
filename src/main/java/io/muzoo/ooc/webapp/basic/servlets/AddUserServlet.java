package io.muzoo.ooc.webapp.basic.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/addUser.jsp");
        requestDispatcher.include(request, response);
    }

    @Override
    public String getPattern() {
        return "/addUser";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String error;
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        if(AccessibleDatabase.USER.checkUserExisted(username)){
//            error = "This username is already existed";
//            request.setAttribute("error", error);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
//            requestDispatcher.include(request, response);
//        }
//        else{
//            AccessibleDatabase.USER.addData(username, password, firstname, lastname);
//            response.sendRedirect("/");
//        }

    }
}
