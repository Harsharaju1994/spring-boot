package org.in60mins.spring.Controller;

import lombok.AllArgsConstructor;
import org.in60mins.spring.dto.EmployeeDto;
import org.in60mins.spring.entity.Employee;
import org.in60mins.spring.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAll(){

        List<EmployeeDto> emp = employeeService.getAllEmployees();
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long employeeId){
        EmployeeDto emp1 = employeeService.getById(employeeId);
        return ResponseEntity.ok(emp1);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EmployeeDto> editEmp(@RequestBody EmployeeDto employeeDto,
                                            @PathVariable("id") Long employeeId){

        EmployeeDto employeeDto1 = employeeService.updateEmp(employeeId,employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") Long employeeId){
        employeeService.deleteEmp(employeeId);
        return ResponseEntity.ok(employeeId+" : deleted Successfully...!");
    }
}
