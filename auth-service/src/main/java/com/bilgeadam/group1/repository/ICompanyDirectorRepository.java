package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.CompanyDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICompanyDirectorRepository extends JpaRepository<CompanyDirector,Long> {

    Optional<CompanyDirector> findOptionalByEmailAndPassword(String email, String password);
    List<CompanyDirector> findAll();
    Optional<CompanyDirector> findOptionalByEmail(String email);
    Optional<CompanyDirector> findOptionalByToken(String token);
}
