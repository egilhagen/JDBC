package no.accelerate.assignmet2.repositories;

import java.util.List;

public interface CRUDRepository <T> {
    List<T> getAll();
}
