package org.l0gik67.controller;


import org.l0gik67.entity.Employee;
import org.l0gik67.exeption_handling.EmployeeIncorrectData;
import org.l0gik67.exeption_handling.NoSuchEmployeeException;
import org.l0gik67.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
            throw new NoSuchEmployeeException("There is no employee with id = " + id);
        }
        return employeeService.getEmployee(id);
    }



    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("There is no employee with id = " + id);
        }
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }
}
