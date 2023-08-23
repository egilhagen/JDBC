package no.accelerate.assignmet2.repositories.customerCountry;

import no.accelerate.assignmet2.dao.models.CustomerCountry;
import no.accelerate.assignmet2.repositories.CRUDRepository;

public interface CustomerCountryRepo extends CRUDRepository<CustomerCountry> {
    CustomerCountry getCountryWithHighestCount();
}
