package com.Demos.crudEmployees.dao;

import com.Demos.crudEmployees.entity.Employee;

import java.util.List;

public interface employeeDAO {

    List<Employee> findAll();

    void deleteById(int theId);
    Employee findById(int theId);

    Employee save(Employee theEmployee);
}
