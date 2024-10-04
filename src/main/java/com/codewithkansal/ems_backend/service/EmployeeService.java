package com.codewithkansal.ems_backend.service;

import com.codewithkansal.ems_backend.dto.EmployeeDTO;
import com.codewithkansal.ems_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId,EmployeeDTO updatedEmployeeDTO);

    void deleteEmployee(Long employeeId);
}
