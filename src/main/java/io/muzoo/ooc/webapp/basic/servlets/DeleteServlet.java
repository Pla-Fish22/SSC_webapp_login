package io.muzoo.ooc.webapp.basic.servlets;

import io.muzoo.ooc.webapp.basic.security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends AbstractRoutableHttpServlet{

    @Override
    public String getPattern() {
        return "/delete";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) {
            request.setAttribute("deletingUser", request.getParameter("userName"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/delete.jsp");
            requestDispatcher.include(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toDelete = request.getParameter("deleting");
        new UserService().deleteUser(toDelete);
        response.sendRedirect("/");
    }
}
