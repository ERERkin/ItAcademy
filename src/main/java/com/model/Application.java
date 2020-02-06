package com.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.DB.DB.connect;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Application {
    Integer id;
    String fullName;
    String email;
    String course;
    Boolean isOnline;
    public static boolean addApplicationToBD(Application application){
        String SQL = "insert into application (full_name, email, course, is_online) values (?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL);) {
            stmt.setString(1, application.getFullName());
            stmt.setString(2, application.getEmail());
            stmt.setString(3, application.getCourse());
            stmt.setBoolean(4, application.getIsOnline());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static ArrayList<Application> applicationArrayList(){
        ArrayList<Application> applications = new ArrayList<>();
        String SQL = "insert into application (full_name, email, course, is_online) values (?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL);) {
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()){
                    applications.add(new Application(rs.getInt("id"),
                            rs.getString("full_name"),
                            rs.getString("email"),
                            rs.getString("course"),
                            rs.getBoolean("")));
                }
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return applications;
    }
}
