package com.example.employeefullstack.controller;

import com.example.employeefullstack.model.Employee;
import com.example.employeefullstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        Employee e=employeeService.addEmployee(employee);
        return new ResponseEntity<>(e, HttpStatus.CREATED) ;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Void>( HttpStatus.OK) ;
    }


}
