package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyProfileRepository extends JpaRepository<CompanyManagerProfile, Long> {

    Optional<CompanyManagerProfile> findOptionalByName(String name);

}
