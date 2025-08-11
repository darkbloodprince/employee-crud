package com.example.employeecrud.repository;

import com.example.employeecrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom query methods here if needed
	List<Employee> findByDepartment(String department);
}
