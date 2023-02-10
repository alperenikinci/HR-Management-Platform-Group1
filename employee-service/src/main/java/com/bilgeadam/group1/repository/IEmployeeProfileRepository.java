package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeProfileRepository extends JpaRepository <EmployeeProfile,Long> {

    Optional<EmployeeProfile> findOptionalByEmail(String email);

    Optional<EmployeeProfile> findOptionalByToken(String token);
}
