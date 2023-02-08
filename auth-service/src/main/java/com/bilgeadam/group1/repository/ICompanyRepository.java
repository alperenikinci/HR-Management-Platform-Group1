package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Long> {


}
