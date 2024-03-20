package com.Demos.crudEmployees.service;

import com.Demos.crudEmployees.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();


    void deleteById(int theId);
    Employee findById(int theId);

    Employee save(Employee theEmployee);


}
