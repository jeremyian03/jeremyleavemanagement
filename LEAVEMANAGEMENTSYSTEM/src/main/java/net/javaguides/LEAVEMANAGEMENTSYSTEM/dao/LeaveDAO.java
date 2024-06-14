package net.javaguides.LEAVEMANAGEMENTSYSTEM.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.LEAVEMANAGEMENTSYSTEM.model.Leave;

public class LeaveDAO {
    private String jdbcURL = "jdbc:derby:C:\\Users\\Carlito's\\MyDB;create=true";
    private String jdbcUsername = "Admin";
    private String jdbcPassword = "12345";

    private static final String INSERT_LEAVE_SQL = "INSERT INTO leaves" + "  (name, leave_type, status) VALUES "
            + " (?,?,?)";

    private static final String SELECT_LEAVE_BY_ID = "select id, name, leave_type, status from leaves where id =?";
    private static final String SELECT_ALL_LEAVES = "select * from leaves";
    private static final String DELETE_LEAVE_SQL = "delete from leaves where id =?";
    private static final String UPDATE_LEAVE_SQL = "update leaves set name =?, leave_type =?, status =? where id =?";

    public LeaveDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertLeave(Leave leave) throws SQLException {
        System.out.println(INSERT_LEAVE_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LEAVE_SQL)) {
            preparedStatement.setString(1, leave.getName());
            preparedStatement.setString(2, leave.getLeaveType());
            preparedStatement.setString(3, leave.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Leave selectLeave(int id) {
        Leave leave = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LEAVE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String leaveType = rs.getString("leave_type");
                String status = rs.getString("status");
                leave = new Leave(id, name, leaveType, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return leave;
    }

    public List<Leave> selectAllLeaves() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Leave> leaves = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LEAVES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String leaveType = rs.getString("leave_type");
                String status = rs.getString("status");
                leaves.add(new Leave(id, name, leaveType, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return leaves;
    }

    public boolean deleteLeave(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_LEAVE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateLeave(Leave leave) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_LEAVE_SQL);) {
            statement.setString(1, leave.getName());
            statement.setString(2, leave.getLeaveType());
            statement.setString(3, leave.getStatus());
            statement.setInt(4, leave.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if(e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t!= null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    }
