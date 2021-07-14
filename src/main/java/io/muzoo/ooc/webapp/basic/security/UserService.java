package io.muzoo.ooc.webapp.basic.security;


import io.muzoo.ooc.webapp.basic.database.DatabaseManager;
import org.mindrot.jbcrypt.BCrypt;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    private DatabaseManager databaseManager = new DatabaseManager();

    private final String FIND_ONE_QUERY = "SELECT * FROM user_tbl where username = ?;";
    private final String FIND_ALL_QUERY = "SELECT * FROM user_tbl;";
    private final String INSERT_USER_QUERY = "INSERT INTO user_tbl (username, password, firstname,lastname) VALUES (?,?,?,?);";
    private final String DELETE_USER_QUERY = "DELETE FROM user_tbl where username=?;";
    private final String EDIT_PASSWORD_QUERY = "UPDATE user_tbl SET password = ? WHERE username = ?;";
    private final String EDIT_FIRSTNAME_QUERY = "UPDATE user_tbl SET firstname = ? WHERE username = ?;";
    private final String EDIT_LASTNAME_QUERY = "UPDATE user_tbl SET lastname = ? WHERE username = ?;";

    public User findByUsername(String username){
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ONE_QUERY);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            long id = 0;
            String user = null, password = null, firstname = null, lastname = null;
            while (rs.next()) {
                id = rs.getLong(1);
                user = rs.getString(2);
                password = rs.getString(3);
                firstname = rs.getString(4);
                lastname = rs.getString(5);
            }
            rs.close();
            ps.close();
            connection.close();
            if(user == null){
                return null;
            }
            return new User(id, user, password, firstname, lastname);
        }catch (Exception e){
            return null;
        }
    }

    public void createUser(String username, String password, String firstname, String lastname){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER_QUERY);
            ps.setString(1, username);
            ps.setString(2, hashedPassword);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            connection.close();
        } catch (Exception e) {
            return;
        }
    }
    
    public boolean checkIfUserExists(String username) {
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ONE_QUERY);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            String user = null, password = null, firstname = null, lastname = null;
            while (rs.next()) {
                user = rs.getString(2);
                password = rs.getString(3);
                firstname = rs.getString(4);
                lastname = rs.getString(5);
            }
            rs.close();
            ps.close();
            connection.close();
            return user.equals(username);
        }catch (Exception e){
            return false;
        }

    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                users.add(new User(rs.getLong(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getString(5)));
            }
            rs.close();
            ps.close();
            connection.close();
            return users;
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteUser(String username){
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_USER_QUERY);
            ps.setString(1, username);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            connection.close();
        } catch (Exception e) {
            return;
        }


    }

    public void editPassword(String oldPassword, String newPassword){
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(EDIT_PASSWORD_QUERY);
            ps.setString(1, hashedPassword);
            ps.setString(2, oldPassword);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            connection.close();
        } catch (Exception e) {
            return;
        }
    }

    public void editFirstname(String oldFirstname, String newFirstname){
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(EDIT_FIRSTNAME_QUERY);
            ps.setString(1, newFirstname);
            ps.setString(2, oldFirstname);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            connection.close();
        } catch (Exception e) {
            return;
        }

    }

    public void editLastname(String oldLastname, String newLastname){
        try {
            Connection connection = databaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(EDIT_LASTNAME_QUERY);
            ps.setString(1, newLastname);
            ps.setString(2, oldLastname);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            connection.close();
        } catch (Exception e) {
            return;
        }

    }
    
    


}
