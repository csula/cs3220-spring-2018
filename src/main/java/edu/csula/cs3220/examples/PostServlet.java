package edu.csula.cs3220.examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
			"<form action=\"/app/post\" method=\"post\">" +
	"<input type='text' name='name'>" +
	"<input type='text' name='imageUrl'>" +
	"<input type='text' name='description'>" +
	"<button type='Submit'>Submit</button>" +
"</form>"
		);
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("Handling post request");
	}
}
