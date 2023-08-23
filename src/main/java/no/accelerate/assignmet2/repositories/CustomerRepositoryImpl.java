package no.accelerate.assignmet2.repositories;

import no.accelerate.assignmet2.dao.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private final String url;
    private final String username;
    private final String password;

    public CustomerRepositoryImpl(
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves all customers from the database.
     *
     * @return List of Customer objects representing the customers.
     */
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer";
        try (Connection conn = DriverManager.getConnection(url, username, password)){
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
        System.out.println("Here be the customers");
        return customers;
    }

    /**
     * Retrieves a customer by their ID from the database.
     *
     * @param id The ID of the customer to retrieve.
     * @return The Customer object representing the retrieved customer, or null if not found.
     */
    @Override
    public Customer getById(int id) {
        Customer customer = null;
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE customer_id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return customer;
    }

    /**
     * Retrieves customers by their last name using a LIKE query.
     *
     * @param name The last name to search for.
     * @return List of Customer objects matching the last name.
     */
    public List<Customer> getByName(String name){
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE last_name LIKE ?";
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);
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
        System.out.println("Here be the customers");
        return customers;
    }

    /**
     * Adds a new customer to the database.
     *
     * @param customer The Customer object representing the customer to be added.
     * @return The number of rows affected (1 if successful, 0 if not).
     */
    @Override
    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO customer(first_name, last_name, country, postal_code, phone, email) VALUES (?,?,?,?,?,?)";
        int result = 0;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.first_name());
            statement.setString(2, customer.last_name());
            statement.setString(3, customer.country());
            statement.setString(4, customer.postal_code());
            statement.setString(5, customer.phone());
            statement.setString(6, customer.email());
            // Execute statement

            result = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("There be a new customer: ");
        return result;
    }

    /**
     * Deletes a customer by their ID from the database.
     *
     * @param id The ID of the customer to delete.
     * @return The number of rows affected (1 if successful, 0 if not).
     */
    @Override
    public int deleteCustomerById(int id) {
        String selectSql = "SELECT MAX(customer_id) FROM customer";
        String deleteSql = "DELETE FROM customer WHERE customer_id = ?";
        int result = 0;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
                //Find the highest customer_id in the database
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();
            int latestCustomerId = 0;
            if (resultSet.next()) {
                latestCustomerId = resultSet.getInt(1);
            }
            selectStatement.close();

                // Checks if there are any customers with id in the database
                // Removes a customer based on the given id
            if (latestCustomerId > 0) {
                PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                deleteStatement.setInt(1, id);
                result = deleteStatement.executeUpdate();
                System.out.print("There no longer be a customer with the ID " + id + ": ");
            } else {
                System.out.println("No customers found to delete.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Retrieves a limited number of customers with an offset from the database.
     *
     * @param limit  The maximum number of customers to retrieve.
     * @param offset The offset from which to start retrieving customers.
     * @return List of Customer objects representing the retrieved customers.
     */
    @Override
    public List<Customer> getLimit(int limit, int offset) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer LIMIT ? OFFSET ?";
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
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
        System.out.println("Here be the limit");
        return customers;
    }

}



