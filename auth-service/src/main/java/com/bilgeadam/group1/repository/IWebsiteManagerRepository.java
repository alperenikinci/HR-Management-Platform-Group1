package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.WebsiteManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IWebsiteManagerRepository extends JpaRepository<WebsiteManager,Long> {

    Optional<WebsiteManager> findOptionalByEmailAndPassword(String email, String password);

}
