package edu.csula.cs3220.examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int counter = (int) getServletContext().getAttribute("counter");
		out.println("<h1> Hello CS-3220! </h1> <p>Counter : " + counter + "</p>");
		System.out.println(counter);
	}
}
