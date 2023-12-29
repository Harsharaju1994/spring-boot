package org.in60mins.spring.service;

import org.in60mins.spring.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getById(Long employeeId);

    EmployeeDto updateEmp(Long employeeId,EmployeeDto employeeDto);

    void deleteEmp(Long employeeId);
}
