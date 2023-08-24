package no.accelerate.assignmet2.repositories.customer;

import no.accelerate.assignmet2.dao.models.Customer;
import no.accelerate.assignmet2.repositories.CRUDRepository;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer> {
    Customer getById(int id);
    List<Customer> getByLastName(String name);
    int addCustomer(Customer customer);
    int updateCustomer(int id, Customer updatedCustomer);
    int deleteCustomerById(int customerId);
    List<Customer> getLimit(int i, int j);
}
