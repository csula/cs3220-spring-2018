package edu.csula.cs3220.midterm;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup=1, urlPatterns={"/suggest/restaurants/random"})
public class RandomRestaurantServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

        List<Restaurant> list = (List<Restaurant>) getServletContext().getAttribute("midterm-restaurants");
        Restaurant r = getRandomRestaurant(list);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

        out.println("<p>" + r.name + " - " + r.url + " " + r.getDesignRatingAverage() + " " + r.getTasteRatingsAverage() + "</p>");

        out.println("<form method='POST'>");

        out.println("<input type='hidden' name='id' value=\"" + r.name + "\" />");

        out.println("Design rating");
        for (int i = 1; i <= 5; i ++) {
            out.println(generateRadioInput("design_rating", i));
        }
        out.println("Taste rating");
        for (int i = 1; i <= 5; i ++) {
            out.println(generateRadioInput("taste_rating", i));
        }
        out.println("<button>Submit</button>");

        out.println("</form>");

		out.println("<div>");
		out.println("<a href=''>Feeling Lucky</a>");
		out.println("<a href='random/list'>See the list</a>");
		out.println("</div>");
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
        Integer designRating = Integer.parseInt(request.getParameter("design_rating"));
        Integer tasteRating = Integer.parseInt(request.getParameter("taste_rating"));
        System.out.println(designRating);
        System.out.println(tasteRating);

        // update the rating individually to the random variable
        String name = request.getParameter("id");
        System.out.println(name);
        Restaurant random = null;
        List<Restaurant> list = (List<Restaurant>) getServletContext().getAttribute("midterm-restaurants");
        System.out.println(list);
        for (int i = 0; i < list.size(); i ++) {
            Restaurant r = list.get(i);
            if (r.name.equals(name)) {
                random = r;
            }
        }
        random.designRatings.add(designRating);
        random.tasteRatings.add(tasteRating);

        // find the item in the application scope and update it
        int index = -1;
        for (int i = 0; i < list.size(); i ++) {
            Restaurant r = list.get(i);
            if (r.name.equals(random.name)) {
                index = i;
            }
        }
        list.set(index, random);
        getServletContext().setAttribute("midterm-restaurants", list);
        response.sendRedirect("random");
	}


	private String generateRadioInput(String type, int i) {
        return String.format(
            "<input name='%s' id='%s_%d' type='radio' value='%d'>" +
            "<label for='%s_%d'>%d</label>",
            type,
            type,
            i,
            i,
            type,
            i,
            i
        );
	}

	private Restaurant getRandomRestaurant(List<Restaurant> list) {
	    return list.get(new Random().nextInt(list.size()));
    }
}


















