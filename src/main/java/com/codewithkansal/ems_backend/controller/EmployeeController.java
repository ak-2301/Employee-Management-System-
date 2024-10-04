package com.codewithkansal.ems_backend.controller;

import com.codewithkansal.ems_backend.dto.EmployeeDTO;
import com.codewithkansal.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Create Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
       EmployeeDTO savedEmployee= employeeService.createEmployee(employeeDTO);
       return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Get Employee By ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO= employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDTO);
    }

    // Get all Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>>getAllEmployees(){
        List<EmployeeDTO> emp= employeeService.getAllEmployees();
        return ResponseEntity.ok(emp);
    }

    //Update Employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody  EmployeeDTO updatedEmployeeDTO){
       EmployeeDTO emp=  employeeService.updateEmployee(employeeId,updatedEmployeeDTO);
       return  ResponseEntity.ok(emp);
    }

    // Delete Employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
