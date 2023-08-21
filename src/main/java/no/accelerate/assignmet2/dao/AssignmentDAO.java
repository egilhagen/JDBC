package no.accelerate.assignmet2.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class AssignmentDAO {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;


    public AssignmentDAO() {
    }

    public AssignmentDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void testConnection(){
        try (Connection conn = DriverManager.getConnection(url, user, password);){
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

}
