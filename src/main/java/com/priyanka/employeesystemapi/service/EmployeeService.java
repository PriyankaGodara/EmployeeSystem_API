package com.priyanka.employeesystemapi.service;

import com.priyanka.employeesystemapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();
}
