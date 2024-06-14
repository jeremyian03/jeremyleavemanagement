package net.javaguides.LEAVEMANAGEMENTSYSTEM.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.LEAVEMANAGEMENTSYSTEM.model.User;

public class UserDAO {
    private String jdbcURL = "jdbc:derby:C:\\Users\\Carlito's\\MyDB;create=true";
    private String jdbcUsername = "Admin";
    private String jdbcPassword = "12345";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, contact_number, email_address) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";

    public UserDAO() {
    }

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean insertUser(User user) throws SQLException {
        boolean success = false;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getContactNumber());
            preparedStatement.setString(4, user.getEmailAddress());
            success = preparedStatement.executeUpdate() > 0;
        }
        return success;
    }

    public User getUserByUsername(String username) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String contactNumber = rs.getString("contact_number");
                String emailAddress = rs.getString("email_address");
                user = new User(username, password, contactNumber, emailAddress);
                user.setId(id);
            }
        }
        return user;
    }
}