package edu.csula.cs3220.examples.jdbc;

import edu.csula.cs3220.dao.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/jdbc/guestbook/create")
public class CreateGuestBookServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jdbc/guestbook-add.jsp")
            .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String comment = request.getParameter("comment");
        GuestBookEntry newEntry = new GuestBookEntry(-1, name, comment);

        GuestBookDAO dao = new GuestBookDAO();
        dao.add(newEntry);
        response.sendRedirect("../guestbook");
	}
}
