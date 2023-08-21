package no.accelerate.assignmet2;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignmet2Application implements ApplicationRunner {
    final
    AssignmentDAO assignmentDAO;

    public Assignmet2Application(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(Assignmet2Application.class, args);
        AssignmentDAO assignmentDAO = new AssignmentDAO();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        assignmentDAO.test();
    }
}
