package code.thadam.tech.ems_backend.repository;

import code.thadam.tech.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
