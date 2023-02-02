package com.bilgeadam.group1.repository;

import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWebsiteManagerProfileRepository extends JpaRepository <WebsiteManagerProfile, Long> {

    Optional<WebsiteManagerProfile> findOptionalByEmail(String email);

    Optional<WebsiteManagerProfile> findOptionalByToken(String token);

}
