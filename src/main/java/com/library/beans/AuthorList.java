package com.library.beans;

import com.library.connection.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorList {

    private List<Author> authorList = new ArrayList<Author>();

    private List<Author> getAuthors() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;

        connection = Database.getConnection();

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM library.author ORDER BY fio");

            while (rs.next()) {
                Author author = new Author();
                author.setName(rs.getString("fio"));
                authorList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null) stmt.close();
//                if (rs != null)rs.close();
//                if (connection != null) connection.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

        return authorList;
    }

    public List<Author> getAuthorList() {
        if (!authorList.isEmpty()) {
            return authorList;
        } else {
            return getAuthors();
        }
    }
}
