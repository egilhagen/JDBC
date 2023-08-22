package no.accelerate.assignmet2.runners;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import no.accelerate.assignmet2.dao.models.Customer;
import no.accelerate.assignmet2.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AssignmentDAO dao;

    public AssRunner(CustomerRepository customerRepository, AssignmentDAO dao) {
        this.customerRepository = customerRepository;
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {
        dao.test();


        List<Customer> customerList = customerRepository.getLimit(10,15);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }


        System.out.println(customerRepository.getById(2).last_name());

        System.out.println(customerRepository.getByName("Smith"));



    }

}
