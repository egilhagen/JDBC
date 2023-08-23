package no.accelerate.assignmet2.repositories.customerGenre;

import no.accelerate.assignmet2.dao.models.CustomerGenre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerGenreRepoImpl implements CustomerGenreRepo {

    private final String url;
    private final String username;
    private final String password;

    public CustomerGenreRepoImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<CustomerGenre> getAll() {
        List<CustomerGenre> customerGenres = new ArrayList<>();
        String sql =
                "SELECT\n c.customer_id, c.last_name," +
                " genre_counts.genre_id AS most_popular_genre_id," +
                " genre_counts.name AS most_popular_genre_name," +
                " genre_counts.track_count AS most_popular_genre_track_count" +
                " FROM customer AS c" +
                " JOIN (SELECT i.customer_id, t.genre_id, g.name," +
                " COUNT(*) AS track_count,\n" +
                " RANK() OVER (PARTITION BY i.customer_id ORDER BY COUNT(*) DESC) AS genre_rank" +
                " FROM customer AS c " +
                " JOIN invoice AS i ON c.customer_id = i.customer_id" +
                " JOIN invoice_line AS il ON i.invoice_id = il.invoice_id" +
                " JOIN track AS t ON il.track_id = t.track_id" +
                " JOIN genre AS g ON t.genre_id = g.genre_id" +
                " GROUP BY i.customer_id, t.genre_id, g.name) " +
                " AS genre_counts ON c.customer_id = genre_counts.customer_id AND genre_rank = 1" +
                " ORDER BY c.customer_id;";

        try (Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                customerGenres.add(new CustomerGenre(
                        result.getInt("customer_id"),
                        result.getString("most_popular_genre_name"),
                        result.getInt("most_popular_genre_track_count")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("Here be the customers fav genre");
        return customerGenres;
    }

    @Override
    public List<CustomerGenre> getGenreById(int id) {
        List<CustomerGenre> customerGenres = new ArrayList<>();
        String sql =
                "SELECT\n c.customer_id, c.last_name," +
                        " genre_counts.genre_id AS most_popular_genre_id," +
                        " genre_counts.name AS most_popular_genre_name," +
                        " genre_counts.track_count AS most_popular_genre_track_count" +
                        " FROM customer AS c" +
                        " JOIN (SELECT i.customer_id, t.genre_id, g.name," +
                        " COUNT(*) AS track_count,\n" +
                        " RANK() OVER (PARTITION BY i.customer_id ORDER BY COUNT(*) DESC) AS genre_rank" +
                        " FROM customer AS c " +
                        " JOIN invoice AS i ON c.customer_id = i.customer_id" +
                        " JOIN invoice_line AS il ON i.invoice_id = il.invoice_id" +
                        " JOIN track AS t ON il.track_id = t.track_id" +
                        " JOIN genre AS g ON t.genre_id = g.genre_id" +
                        " GROUP BY i.customer_id, t.genre_id, g.name) " +
                        " AS genre_counts ON c.customer_id = genre_counts.customer_id AND genre_rank = 1" +
                        " WHERE c.customer_id = ? " +
                        " ORDER BY c.customer_id;";
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                customerGenres.add(new CustomerGenre(
                        result.getInt("customer_id"),
                        result.getString("most_popular_genre_name"),
                        result.getInt("most_popular_genre_track_count")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("Here be the customers fav genre");
        return customerGenres;
    }


    @Override
    public CustomerGenre getById(int id) {
        return null;
    }

    @Override
    public List<CustomerGenre> getByName(String name) {
        return null;
    }

    @Override
    public List<CustomerGenre> getLimit(int i, int j) {
        return null;
    }
}
