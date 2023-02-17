package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.Expenditure;
import com.bilgeadam.group1.repository.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExpenditureRepository extends JpaRepository<Expenditure,Long> {
    @Query(value = "select * from Expenditure as u where u.employee_id=?1 order by create_request_date desc", nativeQuery = true)
    List<Expenditure> findOptionalByEmployeeId(Long employeeId);
}
