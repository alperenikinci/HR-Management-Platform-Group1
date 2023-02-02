package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebsiteManagerProfileRepository extends JpaRepository <WebsiteManagerProfile, Long> {

}
