package edu.csula.cs3220.examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup=1, urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet {
	public void init() {
		getServletContext().setAttribute("counter", 0);
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ServletContext context = getServletContext();
		int counter = (int) context.getAttribute("counter");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Hello world! </h1> <p>Counter : " + counter + "</p>");
		counter ++;
		context.setAttribute("counter", counter);
	}
}
