package io.muzoo.ooc.webapp.basic.security;


import io.muzoo.ooc.webapp.basic.database.DatabaseManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private DatabaseManager databaseManager = new DatabaseManager();

    private final String FIND_QUERY = "SELECT username,password,firstname,lastname FROM user_tbl where username = ?";

    public User findByUsername(String username){
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_QUERY);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            String user = null, password = null, firstname = null, lastname = null;
            while (rs.next()) {
                user = rs.getString(1);
                password = rs.getString(2);
                firstname = rs.getString(3);
                lastname = rs.getString(4);
            }
            ps.close();
            connection.close();
            return new User(user, password, firstname, lastname);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public boolean checkIfUserExists(String username) {
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_QUERY);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            String user = null, password = null, firstname = null, lastname = null;
            while (rs.next()) {
                user = rs.getString(1);
                password = rs.getString(2);
                firstname = rs.getString(3);
                lastname = rs.getString(4);
            }
            ps.close();
            connection.close();
            return user.equals(username);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


}
