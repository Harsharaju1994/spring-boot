package org.in60mins.spring.mapper;

import org.in60mins.spring.dto.EmployeeDto;
import org.in60mins.spring.entity.Employee;

public class EmployeeMapper
{
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getLocation(),
                employee.getMobileNumber()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getMobileNumber(),
                employeeDto.getLocation()
        );
    }
}
