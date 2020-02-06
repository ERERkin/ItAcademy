package com.DB;

import com.model.Application;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "postgres";
    @SneakyThrows
    public static Connection connect() {
        Class.forName("org.postgresql.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public boolean addApplication(Application application) throws SQLException {
        String SQL = "insert into application (full_name,email,course,is_online)";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setString(1,application.getFullName());
            statement.setString(2,application.getEmail());
            statement.setString(3,application.getCourse());
            statement.setBoolean(4,application.getIsOnline());
            statement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
