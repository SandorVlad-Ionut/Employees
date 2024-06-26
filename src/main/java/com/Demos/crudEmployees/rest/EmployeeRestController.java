package com.Demos.crudEmployees.rest;

import com.Demos.crudEmployees.dao.employeeDAO;
import com.Demos.crudEmployees.entity.Employee;
import com.Demos.crudEmployees.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
    }
        return employeeService.findById(employeeId);


}

@PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
    theEmployee.setId(0);
    employeeService.save(theEmployee);
    return theEmployee;


}

@PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
    employeeService.save(theEmployee);
    return theEmployee;
}


@DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
    Employee tempEmployee = employeeService.findById(employeeId);
    if (tempEmployee == null) {
        throw new RuntimeException("Employee id not found - " + employeeId);
    }
    employeeService.deleteById(employeeId);
    return "Deleted employee id - " + employeeId;


}

}

