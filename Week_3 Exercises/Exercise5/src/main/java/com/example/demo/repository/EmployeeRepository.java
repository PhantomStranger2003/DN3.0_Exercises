package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employee by email
    Employee findByEmail(String email);

    // Derived Query Methods
    List<Employee> findByName(String name);
    List<Employee> findByNameContaining(String name);


    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmailAddress(String email);

    @Query(value = "SELECT * FROM employees WHERE email = ?1", nativeQuery = true)
    Employee findByEmailNative(String email);

    @Query(name = "Employee.findByDepartmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);


}
