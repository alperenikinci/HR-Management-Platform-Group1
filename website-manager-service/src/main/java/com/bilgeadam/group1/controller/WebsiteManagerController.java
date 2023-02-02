package com.bilgeadam.group1.controller;
import com.bilgeadam.group1.dto.request.ProfileUpdateRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import com.bilgeadam.group1.service.WebsiteManagerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    
    @GetMapping("/findbyemail")
    public ResponseEntity<Optional<WebsiteManagerProfile>> findOptionalByEmail(String email){
        return ResponseEntity.ok(websiteManagerProfileService.findByEmail(email));
    }

    @PutMapping(UPDATETOKEN)
    public ResponseEntity<Optional<UpdateTokenResponseDto>> updateTokenByEmail(@RequestBody UpdateTokenRequestDto dto){
        return ResponseEntity.ok(websiteManagerProfileService.updateTokenByEmail(dto));
    }

    @GetMapping("/findbytoken")
    public ResponseEntity<Optional<WebsiteManagerProfile>> findOptionalByToken(String token){
        return ResponseEntity.ok(websiteManagerProfileService.findOptionalByToken(token));
    }

    @PutMapping("/updatebytoken")
    public ResponseEntity<Optional<ProfileUpdateResponse>> updateByToken(ProfileUpdateRequest request){
        return ResponseEntity.ok(websiteManagerProfileService.updateProfileByToken(request));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<WebsiteManagerProfile>> findAll(){
        return ResponseEntity.ok(websiteManagerProfileService.findAll());
    }
}
