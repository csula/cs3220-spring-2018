package edu.csula.cs3220.examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/jstl-examples")
public class JSTLExampleServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    User eric = new User("John", "Liao");
	    request.setAttribute("user", eric);
	    request.setAttribute("day", "some");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 22; i ++) {
            numbers.add(i);
        }
	    request.setAttribute("numbers", numbers);
	    request.setAttribute("date", new Date());
        request.getRequestDispatcher("WEB-INF/jstl-example.jsp")
            .forward(request, response);
	}
}
