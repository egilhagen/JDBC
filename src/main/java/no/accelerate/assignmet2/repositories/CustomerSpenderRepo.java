package no.accelerate.assignmet2.repositories;

import no.accelerate.assignmet2.dao.models.CustomerSpender;

public interface CustomerSpenderRepo extends CRUDRepository<CustomerSpender> {
    CustomerSpender getHighestSpender();
}
