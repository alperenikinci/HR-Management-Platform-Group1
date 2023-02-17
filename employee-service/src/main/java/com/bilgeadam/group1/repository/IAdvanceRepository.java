package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.Advance;
import com.bilgeadam.group1.repository.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdvanceRepository extends JpaRepository<Advance,Long> {
    @Query(value = "select * from Advance as u where u.employee_id=?1 order by create_request_date desc", nativeQuery = true)
    List<Advance> findOptionalByEmployeeId(Long employeeId);
}
