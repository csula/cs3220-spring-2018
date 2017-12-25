package edu.csula.cs3220.midterm;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup=1, urlPatterns={"/suggest/restaurants/random/list"})
public class RandomRestaurantListServlet extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<Restaurant> list = new ArrayList<>();
		for (int i = 1; i <= 22; i ++) {
		    list.add(new Restaurant(
		        "Student "+ i + "'s Restaurant",
		        String.format(
		            "http://cs3.calstatela.edu:8080/cs3220xstu%02d/menu",
		            i
		        ),
		        new ArrayList<>(),
		        new ArrayList<>()
		    ));
		    getServletContext().setAttribute("midterm-restaurants", list);
		}
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		List<Restaurant> list = (List<Restaurant>) getServletContext().getAttribute("midterm-restaurants");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

        // TODO: format the following list format into table format
		for (Restaurant r: list) {
            out.println("<p>" + r.name + " - " + r.url + " " + r.getDesignRatingAverage() + " " + r.getTasteRatingsAverage() + "</p>");
		}

		out.println("<div>");
		out.println("<a href='../random'>Feeling Lucky</a>");
		out.println("<a href=''>See the list</a>");
		out.println("</div>");
	}
}
