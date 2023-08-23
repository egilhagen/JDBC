package no.accelerate.assignmet2.runners;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import no.accelerate.assignmet2.repositories.customerCountry.CustomerCountryRepo;
import no.accelerate.assignmet2.repositories.customer.CustomerRepository;
import no.accelerate.assignmet2.repositories.customerSpender.CustomerSpenderRepo;
import no.accelerate.assignmet2.repositories.customerGenre.CustomerGenreRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AssRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CustomerCountryRepo customerCountryRepo;
    private final CustomerSpenderRepo customerSpenderRepo;
    private final CustomerGenreRepo customerGenreRepo;
    private final AssignmentDAO dao;

    public AssRunner(CustomerRepository customerRepository, CustomerCountryRepo customerCountryRepo, CustomerSpenderRepo customerSpenderRepo, CustomerGenreRepo customerGenreRepo, AssignmentDAO dao) {
        this.customerRepository = customerRepository;
        this.customerCountryRepo = customerCountryRepo;
        this.customerSpenderRepo = customerSpenderRepo;
        this.customerGenreRepo = customerGenreRepo;
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {
        dao.test();

            //Gets a customer by giving id
        System.out.println(customerRepository.getById(2).last_name());

            //Gets a customer by giving last name
        System.out.println(customerRepository.getByName("Smith"));

            //Adds a new customer to database
        // Customer customer = new Customer(0,"Butterbin","Pipelock","Someplace","1222", "420420420","coolman@cooland");
        // System.out.println(customerRepository.addCustomer(customer));

            //Deletes the most recently added customer from the database
        // System.out.println(customerRepository.deleteCustomerById(74));

            //Gets the country with the highest
        System.out.println(customerCountryRepo.getCountryWithHighestCount());

            //Gets the highest spender based on total invoices
        System.out.println(customerSpenderRepo.getHighestSpender());

            //Gets most popular genre per customer:
        customerGenreRepo.getGenreById(12).forEach(System.out::println);

        customerCountryRepo.getAll().forEach(System.out::println);

    }

}
