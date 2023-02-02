package com.bilgeadam.group1.controller;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.service.WebsiteManagerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.group1.constants.RestApi.*;

@RequestMapping(WEBSITEMANAGER)
@RequiredArgsConstructor
@RestController
public class WebsiteManagerController {

    private final WebsiteManagerProfileService websiteManagerProfileService;
    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createWebsiteManagerProfile (@RequestBody WebsiteManagerProfileCreateRequestDto dto){
        websiteManagerProfileService.createWebsiteManagerProfile(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(UPDATETOKEN)
    public ResponseEntity<Boolean> updateToken(@RequestBody UpdateTokenRequestDto dto){
        websiteManagerProfileService.updateToken(dto);
        return ResponseEntity.ok().build();
    }
}
