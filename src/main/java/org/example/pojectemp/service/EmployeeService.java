package org.example.pojectemp.service;

import java.util.Collection;

public interface EmployeeService<T> {
    Collection<T> getAll();
    T getById(Integer id);
    void save(T type);
    void update(T type);
    void delete(Integer id);

}
