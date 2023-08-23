package no.accelerate.assignmet2.runners;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import no.accelerate.assignmet2.dao.models.Customer;
import no.accelerate.assignmet2.repositories.CustomerCountryRepo;
import no.accelerate.assignmet2.repositories.CustomerRepository;
import no.accelerate.assignmet2.repositories.CustomerSpenderRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CustomerCountryRepo customerCountryRepo;
    private final CustomerSpenderRepo customerSpenderRepo;
    private final AssignmentDAO dao;

    public AssRunner(CustomerRepository customerRepository, CustomerCountryRepo customerCountryRepo, CustomerSpenderRepo customerSpenderRepo, AssignmentDAO dao) {
        this.customerRepository = customerRepository;
        this.customerCountryRepo = customerCountryRepo;
        this.customerSpenderRepo = customerSpenderRepo;
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {
        dao.test();


        /*
        List<Customer> customerList = customerRepository.getLimit(10,15);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        */


            //Gets a customer by giving id
        System.out.println(customerRepository.getById(2).last_name());

            //Gets a customer by giving last name
        System.out.println(customerRepository.getByName("Smith"));

            //Gets the country with the highest
        System.out.println(customerCountryRepo.getCountryWithHighestCount());

            //Gets the highest spender based on total invoices
        System.out.println(customerSpenderRepo.getHighestSpender());

            //Adds a new customer to database
        Customer newCustomer = new Customer(0,"Butterbean", "Pieplow","Denmark", "2200","+45 22 33 44 55", "butterbeanpieplow@gmail.com");
        //System.out.println(customerRepository.addCustomer(newCustomer));

            //Deletes the most recently added customer from the database
       System.out.println(customerRepository.deleteCustomerById(74));



    }

}
