package no.accelerate.assignmet2.repositories;

import no.accelerate.assignmet2.dao.models.Customer;

import java.util.List;

public interface CRUDRepository <T> {
    List<T> getAll();

    T getById(int id);

    List<T> getByName(String name);

    List<T> getLimit(int i, int j);

}
