package com.Demos.crudEmployees.service;

import com.Demos.crudEmployees.dao.employeeDAO;
import com.Demos.crudEmployees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private employeeDAO EmployeeDAO;

    @Autowired
    public EmployeeServiceImpl(employeeDAO theEmployeeDAO){
        EmployeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return EmployeeDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        EmployeeDAO.deleteById(theId);

    }

    @Override
    public Employee findById(int theId) {
        return EmployeeDAO.findById(theId);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return EmployeeDAO.save(theEmployee);
    }
}
