package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method to find department by name
    Department findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name = ?1")
    Department findByDepartmentName(String name);

}
