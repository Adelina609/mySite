package ru.kpfu.itis1.repositories;

import ru.kpfu.itis1.objects.UserSimple;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    private static final String ADD = "INSERT INTO \"user\" (email, password, username) VALUES (?, ?, ?)";
    private static final String GET_USER_BY_ID = "SELECT* FROM \"user\" WHERE \"user\".email =?";
    private static final String DELETE = "DELETE FROM \"user\" WHERE \"user\".email = ?";
    private static final String GET_USERS = "SELECT* FROM \"user\"";

    private static SimpleConnectionBuilder connectionBuilder = new SimpleConnectionBuilder();

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionBuilder.getConnection();
    }

    public static void add(UserSimple userDB) {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(ADD, new String[]{"email", "password", "username"})) {
            pst.setString(1, userDB.getEmail());
            pst.setString(2, userDB.getPassword());
            pst.setString(3, userDB.getNickname());
            pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
    }

    public static UserSimple getUserByEmail(String thisemail){
        String pass = "";
        String username ="";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(GET_USER_BY_ID)) {
            pst.setString(1, thisemail);
            ResultSet resultSet = pst.executeQuery();
            if(!resultSet.next()){
                System.out.println("resultset is null");
                return null;
            }
            pass = resultSet.getString("password");
            username = resultSet.getString("username");
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
        UserSimple userSimple = new UserSimple(thisemail, pass, username);
        System.out.println(userSimple.toString() + pass);
        return userSimple;
    }

    public static List<UserSimple> getUsers() {
        List<UserSimple> users = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(GET_USERS);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                users.add(getUserByEmail(rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
        return users;
    }

    public static void deleteUser(String email){
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE)){
            pst.setString(1, email);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
    }
}
