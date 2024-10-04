package com.codewithkansal.ems_backend.mapper;

import com.codewithkansal.ems_backend.dto.EmployeeDTO;
import com.codewithkansal.ems_backend.entity.Employee;

public class EmployeeMapper {

    //map Entity to DTO
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        return employee;
    }
}
