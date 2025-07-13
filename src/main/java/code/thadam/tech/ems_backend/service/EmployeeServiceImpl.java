package code.thadam.tech.ems_backend.service;

import code.thadam.tech.ems_backend.dto.EmployeeDto;
import code.thadam.tech.ems_backend.entity.Employee;
import code.thadam.tech.ems_backend.exception.ResourceNotFoundExcpetion;
import code.thadam.tech.ems_backend.mapper.EmployeeMapper;
import code.thadam.tech.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

     private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);


    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId)
                 .orElseThrow(()->new ResourceNotFoundExcpetion("Employee is not exist whith give id"+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
                -> new ResourceNotFoundExcpetion("Employee is not exist whit given id: "+ employeeId));
          employee.setFirstName(updateEmployee.getFirstName());
          employee.setLastName(updateEmployee.getLastName());
          employee.setEmail(updateEmployee.getEmail());

          Employee updatedEmployee = employeeRepository.save(employee);

          return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
                -> new ResourceNotFoundExcpetion("Employee is not exist whit given id: "+ employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
