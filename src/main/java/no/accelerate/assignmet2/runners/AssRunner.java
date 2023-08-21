package no.accelerate.assignmet2.runners;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AssRunner implements CommandLineRunner {

    private final AssignmentDAO dao;

    public AssRunner(AssignmentDAO dao) {
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {
        dao.test();
    }

}
