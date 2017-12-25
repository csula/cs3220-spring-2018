package edu.csula.cs3220.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloJDBC")
public class HelloJDBC extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HelloJDBC() {
        super();
    }

    public void init( ServletConfig config ) throws ServletException {
        super.init( config );

        // load driver
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch( ClassNotFoundException e ) {
            throw new ServletException( e );
        }
    }

    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println( "<!DOCTYPE html>" );
        out.println( "<html><head><title>Hello JDBC</title></head><body>" );

        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost/cs3220_test";
            String username = "root";
            String password = "";

            // CS3 server example
            // String url = "jdbc:mysql://localhost/cs3220xstu25";
            // String username = "cs3220xstu25";
            // String password = "password";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM employees" );

            while( rs.next() ) {
                out.println( rs.getString( "id" ) );
                out.println( rs.getString( "first_name" ) );
                out.println( rs.getString( "last_name" ) );
                out.println( rs.getFloat( "supervisor_id" ) );
                out.println( "<br>" );
            }

            c.close();
        } catch( SQLException e ) {
            throw new ServletException( e );
        } finally {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        out.print( "</body></html>" );
    }
}
