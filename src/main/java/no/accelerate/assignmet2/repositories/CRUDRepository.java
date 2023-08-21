package no.accelerate.assignmet2.repositories;

import java.util.List;

public interface CRUDRepository <T> {
    List<T> getAll();
    T getById(int id);
    int create(T obj);
    int update(T obj);
    int delete(int id);
}
