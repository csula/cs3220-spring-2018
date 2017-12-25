package edu.csula.cs3220.examples;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/guestbook/create")
public class CreateGuestBookServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<form method=\"post\">");
		out.println("Your name: <input name='name' type='text'/></br>");
		out.println("<textarea name='comment'></textarea></br>");
		out.println("<button>Add</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		entries.add(new GuestBookEntry(entries.size(), request.getParameter("name"), request.getParameter("comment")));
		getServletContext().setAttribute("entries", entries);
		PrintWriter out = response.getWriter();
		out.println("<a href='/app/guestbook'>go back to guestbook</a>");
	}
}
