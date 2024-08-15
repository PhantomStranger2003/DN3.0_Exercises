package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Derived query method to find employee by email
    Employee findByEmail(String email);

    // Paginated and Sorted Employee List
    Page<Employee> findAll(Pageable pageable);

    // Method to find employees by name with pagination
    Page<Employee> findByNameContaining(String name, Pageable pageable);
}
