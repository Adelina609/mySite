package ru.kpfu.itis1.repositories;

import ru.kpfu.itis1.objects.Article;
import ru.kpfu.itis1.objects.Source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourcesRepository {

    private static final String ADD = "INSERT INTO \"sources\" (name, description, link) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM \"sources\" WHERE \"sources\".name = ?";
    private static final String GET_ARTICLES = "SELECT* FROM \"sources\"";

    private static SimpleConnectionBuilder connectionBuilder = new SimpleConnectionBuilder();

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionBuilder.getConnection();
    }

    public static void add(Source source) {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(ADD, new String[]{"name", "description", "link"})) {
            pst.setString(1, source.getName());
            pst.setString(2, source.getDescription());
            pst.setString(3, source.getLink());
            pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
    }

    public static List<Source> getSources() {
        List<Source> sources = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(GET_ARTICLES);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                sources.add(new Source(rs.getString("name"),
                        rs.getString("description"), rs.getString("link")));
            }
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(sources.toArray()));
        return sources;
    }

//    public static void deleteSource(String name){
//        try (Connection con = getConnection();
//             PreparedStatement pst = con.prepareStatement(DELETE)){
//            pst.setString(1, name);
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("SQL exc");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Class not found exc");
//            e.printStackTrace();
//        }
//    }
}
