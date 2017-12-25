package edu.csula.cs3220.examples;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup=1, urlPatterns={"/guestbook"})
public class GuestBookServlet extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<GuestBookEntry> entries = new ArrayList<>();
		entries.add(new GuestBookEntry(entries.size(), "Eric", "Hello"));
		entries.add(new GuestBookEntry(entries.size(), "John", "Hi there"));
		getServletContext().setAttribute("entries", entries);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " +
		"}</style>");
		out.println("</head>");

		out.println("<h1> Hello GuestBook! </h1>");
		out.println("<table>");
		for (GuestBookEntry entry: entries) {
			out.println(
				"<tr>" + 
					"<td>" + entry.getName() + " says: </td>" + 
					"<td>" + entry.getComment() + "</td>" +
					"<td><a href='guestbook/edit?id=" + entry.getId() + "'>Edit</a> " + 
					"<a href='guestbook/delete?id=" + entry.getId() + "'>Delete</a></td>" +
				"</tr>"
			);
		}
		out.println("</table>");
		out.println("<a href='guestbook/create'>Add comemnt</a>");
	}
}
