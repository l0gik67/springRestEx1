package org.l0gik67.dao;

import org.l0gik67.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
