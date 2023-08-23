package no.accelerate.assignmet2.repositories.customerSpender;

import no.accelerate.assignmet2.dao.models.CustomerSpender;
import no.accelerate.assignmet2.repositories.CRUDRepository;

public interface CustomerSpenderRepo extends CRUDRepository<CustomerSpender> {
    CustomerSpender getHighestSpender();
}
