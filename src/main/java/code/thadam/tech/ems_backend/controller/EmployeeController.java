package code.thadam.tech.ems_backend.controller;

import code.thadam.tech.ems_backend.dto.EmployeeDto;
import code.thadam.tech.ems_backend.entity.Employee;
import code.thadam.tech.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

        private EmployeeService employeeService;

        @PostMapping
        public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
            EmployeeDto savedEmplyoeee = employeeService.createEmployee(employeeDto);
            return new ResponseEntity<>(savedEmplyoeee, HttpStatus.CREATED);
        }
        @GetMapping("{id}")
        public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
            List<EmployeeDto> employees = employeeService.getAllEmployees();

            return new ResponseEntity<>(employees, HttpStatus.OK);
        }

        @PutMapping("{id}")
        public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {
            EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee );
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {

            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.ok("Employee Deleted Successfully!");
        }
}

