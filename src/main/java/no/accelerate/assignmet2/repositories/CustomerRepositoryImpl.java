package no.accelerate.assignmet2.repositories;

import org.springframework.beans.factory.annotation.Value;

public class CustomerRepositoryImpl {
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
}
