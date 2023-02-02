package com.bilgeadam.group1.controller;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.WebsiteManagerProfileCreateResponseDto;
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
    public ResponseEntity<WebsiteManagerProfileCreateResponseDto> createWebsiteManagerProfile (@RequestBody WebsiteManagerProfileCreateRequestDto dto){
        return ResponseEntity.ok(websiteManagerProfileService.createWebsiteManagerProfile(dto));
    }
}
