package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.Permission;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Long> {
    @Query(value = "select * from Permission as u where u.employee_id=?1 order by create_request_date desc", nativeQuery = true)
    List<Permission> findOptionalByEmployeeId(Long employeeId);


}
