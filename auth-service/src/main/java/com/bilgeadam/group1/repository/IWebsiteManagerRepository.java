package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.WebsiteManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IWebsiteManagerRepository extends JpaRepository<WebsiteManager,Long> {


    List<WebsiteManager> findAll(WebsiteManager websiteManager);
}
