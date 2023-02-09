package com.bilgeadam.group1.controller;


import com.bilgeadam.group1.dto.request.company.CreateCompanyRequestDto;
import com.bilgeadam.group1.dto.request.companydirector.RegisterCompanyDirectorRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.LoginRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.company.FindAllCompaniesByBriefResponse;
import com.bilgeadam.group1.dto.response.websitemanager.LoginResponseDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.Company;
import com.bilgeadam.group1.repository.entity.WebsiteManager;
import com.bilgeadam.group1.service.CompanyDirectorService;
import com.bilgeadam.group1.service.CompanyService;
import com.bilgeadam.group1.service.WebsiteManagerService;
import com.bilgeadam.group1.utility.JwtTokenManager;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.bilgeadam.group1.constants.RestApi.*;
@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final WebsiteManagerService websiteManagerService;
    private final CompanyDirectorService companyDirectorService;
    private final CompanyService companyService;
    private final JwtTokenManager jwtTokenManager;


    @PostMapping(REGISTERWEBSITEMANAGER)
    @Operation(summary = "Website manager kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerWebsiteManager(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok(websiteManagerService.registerWebsiteManager(dto));
    }

    @PostMapping(REGISTERCOMPANYDIRECTOR)
    @Operation(summary = "Company director kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerCompanyDirector(@RequestBody @Valid RegisterCompanyDirectorRequestDto dto){
        return  ResponseEntity.ok(companyDirectorService.registerCompanyDirector(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto){
        return  ResponseEntity.ok(websiteManagerService.login(dto));
    }

    @PostMapping("/loginascompanydirector")
    public ResponseEntity<LoginResponseDto> loginAsCompanyDirector(@RequestBody @Valid LoginRequestDto dto){
        return ResponseEntity.ok(websiteManagerService.loginAsCompanyDirector(dto));
    }

    @GetMapping(FINDALLWEBSITEMANAGERS)
    public ResponseEntity<List<WebsiteManager>> findAll(){
        System.out.println();
        return ResponseEntity.ok(websiteManagerService.findAll());
    }

    @PostMapping(CREATECOMPANY)
    public ResponseEntity<String> createCompany(@RequestBody @Valid CreateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.createCompany(dto));
    }

    @GetMapping(FINDCOMPANIESBYBRIEFINFORMATION)
    public ResponseEntity<List<FindAllCompaniesByBriefResponse>> findAllByBriefInfo(){
        return ResponseEntity.ok(companyService.findAllWithBriefInformation());
    }

    @GetMapping(FINDALLCOMPANIES)
    public ResponseEntity<List<Company>> findAllCompanies(){
        return ResponseEntity.ok(companyService.findAll());
    }


}
