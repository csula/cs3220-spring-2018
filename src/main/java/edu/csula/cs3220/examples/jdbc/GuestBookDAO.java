package edu.csula.cs3220.examples.jdbc;

import edu.csula.cs3220.dao.DAO;
import edu.csula.cs3220.dao.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class GuestBookDAO implements DAO<GuestBookEntry> {
    public List<GuestBookEntry> list() {
        List<GuestBookEntry> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM guestbook");
            while (rs.next()) {
                list.add(new GuestBookEntry(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("message")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<GuestBookEntry> get(int id) {
        return Optional.empty();
    }

    public void add(GuestBookEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO guestbook (name, message) VALUES (?, ?)");
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getComment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(GuestBookEntry entry) {

    }

    public void delete(int id) {
    }
}
