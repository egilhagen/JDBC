package no.accelerate.assignmet2.repositories;

import no.accelerate.assignmet2.dao.models.Customer;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer> {

    int addCustomer(Customer customer);


    int deleteCustomerById(int customerId);
}
