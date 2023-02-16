package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.Auth;
import com.bilgeadam.group1.repository.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findOptionalByEmailAndPassword(String email, String password);
    List<Auth> findAll();
    List<Auth> findAllByRole(Roles roles);
    Optional<Auth> findByRole(Roles role);
    Optional<Auth> findOptionalByEmail(String email);
    Optional<Auth> findOptionalByToken(String token);
}
