package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.WebsiteManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IWebsiteManagerRepository extends JpaRepository<WebsiteManager,Long> {

    Optional<WebsiteManager> findOptionalByEmailAndPassword(String email, String password);
    List<WebsiteManager> findAll();
    Optional<WebsiteManager> findOptionalByEmail(String email);


}
