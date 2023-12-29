package org.in60mins.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.in60mins.spring.dto.EmployeeDto;
import org.in60mins.spring.entity.Employee;
import org.in60mins.spring.exception.ResourceNotFoundException;
import org.in60mins.spring.mapper.EmployeeMapper;
import org.in60mins.spring.repository.EmployeeRepo;
import org.in60mins.spring.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee updatedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> emp = employeeRepo.findAll();
        return emp.stream().map((e)->EmployeeMapper.mapToEmployeeDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(Long employeeId) {
        Employee emp1 = employeeRepo.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Sorry this number not available...!"));
        return EmployeeMapper.mapToEmployeeDto(emp1);
    }

    @Override
    public EmployeeDto updateEmp(Long employeeId, EmployeeDto employeeDto) {
        Employee emp1 = employeeRepo.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Sorry this number not available...! "+employeeId));
        emp1.setFirstName(employeeDto.getFirstName());
        emp1.setLastName(employeeDto.getLastName());
        emp1.setEmail(employeeDto.getEmail());
        emp1.setLocation(employeeDto.getLocation());
        emp1.setMobileNumber(employeeDto.getMobileNumber());
        Employee updatedEmp = employeeRepo.save(emp1);

        return EmployeeMapper.mapToEmployeeDto((updatedEmp));
    }

    @Override
    public void deleteEmp(Long employeeId) {
        Employee emp2 = employeeRepo.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Sorry ...! "+employeeId));
        employeeRepo.deleteById(employeeId);
    }
}


