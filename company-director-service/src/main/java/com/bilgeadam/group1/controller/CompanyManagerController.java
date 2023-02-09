package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.CompanyManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.request.ProfileUpdateRequest;
import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import com.bilgeadam.group1.service.CompanyManagerProfileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.group1.constants.RestApi.*;

@RequestMapping(COMPANYMANAGER)
@RestController
@RequiredArgsConstructor
public class CompanyManagerController {

    private final CompanyManagerProfileService companyManagerProfileService;


    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createCompanyManagerProfile (@RequestBody CompanyManagerProfileCreateRequestDto dto){
        companyManagerProfileService.createCompanyManagerProfile(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDBYEMAIL)
    public ResponseEntity<Optional<CompanyManagerProfile>> findOptionalByEmail(String email){
        return ResponseEntity.ok(companyManagerProfileService.findByEmail(email));
    }

    @PutMapping(UPDATETOKEN)
    public ResponseEntity<Optional<UpdateTokenResponseDto>> updateTokenByEmail(@RequestBody UpdateTokenRequestDto dto){
        return ResponseEntity.ok(companyManagerProfileService.updateTokenByEmail(dto));
    }

    @GetMapping(FINDBYTOKEN)
    public ResponseEntity<Optional<CompanyManagerProfile>> findOptionalByToken(String token){
        return ResponseEntity.ok(companyManagerProfileService.findOptionalByToken(token));
    }

    @PutMapping(UPDATEBYTOKEN)
    public ResponseEntity<Optional<ProfileUpdateResponse>> updateByToken(ProfileUpdateRequest request){
        return ResponseEntity.ok(companyManagerProfileService.updateProfileByToken(request));
    }


    @GetMapping(FINDALL)
    public ResponseEntity<List<CompanyManagerProfile>> findAll(){
        return ResponseEntity.ok(companyManagerProfileService.findAll());
    }


    @GetMapping(FINDALLBYSUMMARISEDINFORMATION)
    public ResponseEntity<List<SummarisedFindAllResponse>> findAllResponse(){
        return ResponseEntity.ok(companyManagerProfileService.findAllBySummarisedInformation());
    }
}
