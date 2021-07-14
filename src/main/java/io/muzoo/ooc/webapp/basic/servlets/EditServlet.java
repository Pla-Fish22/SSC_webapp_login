package io.muzoo.ooc.webapp.basic.servlets;

import io.muzoo.ooc.webapp.basic.security.User;
import io.muzoo.ooc.webapp.basic.security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends AbstractRoutableHttpServlet{

    @Override
    public String getPattern() {
        return "/edit";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(securityService.isAuthorized(request)) {
            String editingUsername = request.getParameter("userName");
            request.setAttribute("userName", editingUsername);
            request.setAttribute("editingUser" , new UserService().findByUsername(editingUsername));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/edit.jsp");
            requestDispatcher.include(request, response);
        }
        else{
            response.sendRedirect("/login");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        UserService userService = new UserService();
        String newPassword = request.getParameter("password");
        String newFirstname = request.getParameter("firstname");
        String newLastname = request.getParameter("lastname");
        String username = (String) request.getParameter("editing");
        if(newPassword != null){
            userService.editPassword(username, newPassword);
        }
        if(newFirstname != null){
            userService.editFirstname(username, newFirstname);
        }
        if(newLastname != null){

            userService.editLastname(username, newLastname);
        }
        response.sendRedirect("/");
    }


}
