package ru.kpfu.itis1.repositories;

import ru.kpfu.itis1.objects.Article;
import ru.kpfu.itis1.objects.UserSimple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArticlesRepository {

    private static final String ADD = "INSERT INTO \"articles\" (username, title, text) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM \"articles\" WHERE \"articles\".username = ? AND \"articles\".title = ?";
    //ограничение 5 статей
    private static final String GET_ARTICLES = "SELECT* FROM \"articles\" LIMIT 5";

    private static SimpleConnectionBuilder connectionBuilder = new SimpleConnectionBuilder();

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionBuilder.getConnection();
    }

    public static void add(Article article) {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(ADD, new String[]{"username", "title", "text"})) {
            pst.setString(1, article.getUsername());
            pst.setString(2, article.getTitle());
            pst.setString(3, article.getText());
            pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
    }

    public static List<Article> getArticles() {
        List<Article> articles = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(GET_ARTICLES);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                articles.add(new Article(rs.getString("username"),
                        rs.getString("title"), rs.getString("text")));
            }
        } catch (SQLException e) {
            System.out.println("SQL exc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(articles.toArray()));
        return new LinkedList<>();
    }

    public static void deleteArticle(String username, String title){
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE)){
            pst.setString(1, username);
            pst.setString(2, title);
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
