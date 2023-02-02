package com.bilgeadam.group1.manager;

import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.bilgeadam.group1.constants.RestApi.CREATE;
import static com.bilgeadam.group1.constants.RestApi.UPDATETOKEN;

@FeignClient(url = "http://localhost:8091/api/v1/websitemanager",name = "websitemanager-websitemanagerprofile",decode404 = true)
public interface IWebsiteManagerManager {

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createWebsiteManagerProfile (@RequestBody WebsiteManagerProfileCreateRequestDto dto);

    @PostMapping(UPDATETOKEN)
    public ResponseEntity<Boolean> updateToken(@RequestBody String token);
}
