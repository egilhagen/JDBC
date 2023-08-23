package no.accelerate.assignmet2.repositories.customerGenre;

import no.accelerate.assignmet2.dao.models.CustomerGenre;
import no.accelerate.assignmet2.repositories.CRUDRepository;

import java.util.List;

public interface CustomerGenreRepo extends CRUDRepository<CustomerGenre> {
    List<CustomerGenre> getGenreById(int id);
}
