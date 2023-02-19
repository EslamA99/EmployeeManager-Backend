package com.example.employeefullstack.service;

import com.example.employeefullstack.exception.UserNotFoundException;
import com.example.employeefullstack.model.Employee;
import com.example.employeefullstack.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getEmployeeCode()==null)
            employee.setEmployeeCode(UUID.randomUUID().toString());
        Employee e=employeeRepository.save(employee);
        return e;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
