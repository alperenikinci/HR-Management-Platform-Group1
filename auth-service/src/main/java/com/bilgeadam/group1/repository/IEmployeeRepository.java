package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findOptionalByEmailAndPassword(String email, String password);
    List<Employee> findAll();
    Optional<Employee> findOptionalByEmail(String email);


}
