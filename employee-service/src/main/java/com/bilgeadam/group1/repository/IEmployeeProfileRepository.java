package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeProfileRepository extends JpaRepository <EmployeeProfile,Long> {
}