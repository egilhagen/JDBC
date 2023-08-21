package no.accelerate.assignmet2;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignmet2Application {
    public static void main(String[] args) {
        SpringApplication.run(Assignmet2Application.class, args);
    }
}
