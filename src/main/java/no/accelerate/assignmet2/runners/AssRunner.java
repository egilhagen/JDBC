package no.accelerate.assignmet2.runners;

import no.accelerate.assignmet2.dao.AssignmentDAO;
import no.accelerate.assignmet2.dao.models.Customer;
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
        /*
        REQUIREMENT 1 - Get All
        =================================
        */
        customerRepository.getAll().forEach(System.out::println);
        /*
        =================================
        REQUIREMENT 2 - Gets a customer based on ID
        =================================
         */
        System.out.println(customerRepository.getById(2).last_name());
        /*
        =================================
        REQUIREMENT 3 - Gets a customer by giving last name
        =================================
         */
        System.out.println(customerRepository.getByLastName("Smith"));
        /*
        =================================
        REQUIREMENT 4 - Get a page of customers
        =================================
         */
        customerRepository.getLimit(10,10).forEach(System.out::println);
        /*
        =================================
        REQUIREMENT 5 - Add a new customer to database
        =================================
        */
        Customer customer = new Customer(0,"Butterbin","Pipelock","Someplace","1222", "420420420","coolman@cooland");
        System.out.println(customerRepository.addCustomer(customer));
        /*
        =================================
        REQUIREMENT 6 - Updates the customer with the given ID
        =================================
         */
        Customer updatedCustomer = new Customer(0,"Butterbasket","Babyface","Everywhere","1222", "420420420","coolman@cooland");
        System.out.println(customerRepository.updateCustomer(77, updatedCustomer));
        /*
        =================================
        REQUIREMENT 7 - Gets the country with the most customers
        =================================
         */
        System.out.println(customerCountryRepo.getCountryWithHighestCount());
        /*
        =================================
        REQUIREMENT 8 - Customer who is the highest spender
        =================================
        */
        System.out.println(customerSpenderRepo.getHighestSpender());
        /*
        =================================
        REQUIREMENT 9 - For a given customer, their most popular genre
        =================================
        */
        customerGenreRepo.getGenreById(12).forEach(System.out::println);
        /*
        =================================
        */

    }

}
