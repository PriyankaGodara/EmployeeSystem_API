package com.priyanka.employeesystemapi.service;

import com.priyanka.employeesystemapi.entity.EmployeeEntity;
import com.priyanka.employeesystemapi.model.Employee;
import com.priyanka.employeesystemapi.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee createEmployee(Employee employee){
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = employeeEntities.stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }
}
