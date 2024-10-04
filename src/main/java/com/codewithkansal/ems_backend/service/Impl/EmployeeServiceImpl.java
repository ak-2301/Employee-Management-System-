package com.codewithkansal.ems_backend.service.Impl;

import com.codewithkansal.ems_backend.dto.EmployeeDTO;
import com.codewithkansal.ems_backend.entity.Employee;
import com.codewithkansal.ems_backend.exception.ResourceNotFoundException;
import com.codewithkansal.ems_backend.mapper.EmployeeMapper;
import com.codewithkansal.ems_backend.repository.EmployeeRepository;
import com.codewithkansal.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }


    //create Employee
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    //Get Employee by id
    @Override
    public EmployeeDTO getEmployeeById (Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee is not exist"+employeeId));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    //get all employees
    @Override
    public List<EmployeeDTO> getAllEmployees(){
       List<Employee>emp= employeeRepository.findAll();
       return emp.stream().map((employee) ->EmployeeMapper.mapToEmployeeDTO(employee) ).collect(Collectors.toList());
    }

    //update employee
    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDTO) {
       Employee emp= employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist"+employeeId));
       emp.setFirstName(updatedEmployeeDTO.getFirstName());
       emp.setLastName(updatedEmployeeDTO.getLastName());
       emp.setEmail(updatedEmployeeDTO.getEmail());

       Employee updateEmployeeObj =employeeRepository.save(emp);

       return EmployeeMapper.mapToEmployeeDTO(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee emp= employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist"+employeeId));

        employeeRepository.deleteById(employeeId);
    }


}
