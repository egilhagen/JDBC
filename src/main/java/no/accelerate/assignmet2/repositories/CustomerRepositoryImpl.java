package no.accelerate.assignmet2.repositories;

import no.accelerate.assignmet2.dao.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private String url;
    private String user;
    private String password;

    public CustomerRepositoryImpl(@Value("${spring.datasource.url}") String url,
                                  @Value("${spring.datasource.username}") String user,
                                  @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer";
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                customers.add(new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return customers;
    }


    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public int create(Customer obj) {
        return 0;
    }

    @Override
    public int update(Customer obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}

