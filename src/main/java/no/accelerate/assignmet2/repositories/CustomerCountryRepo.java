package no.accelerate.assignmet2.repositories;

import no.accelerate.assignmet2.dao.models.CustomerCountry;

public interface CustomerCountryRepo extends CRUDRepository<CustomerCountry> {
    CustomerCountry getCountryWithHighestCount();
}
