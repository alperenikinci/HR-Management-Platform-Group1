package com.bilgeadam.group1.controller;


import com.bilgeadam.group1.dto.request.RegisterEmployeeRequestDto;
import com.bilgeadam.group1.dto.request.company.CreateCompanyRequestDto;
import com.bilgeadam.group1.dto.request.companydirector.RegisterCompanyDirectorRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.LoginRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.company.FindAllCompaniesByBriefResponse;
import com.bilgeadam.group1.dto.response.websitemanager.LoginResponseDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.Auth;
import com.bilgeadam.group1.repository.entity.Company;
import com.bilgeadam.group1.repository.enums.Roles;
import com.bilgeadam.group1.service.*;
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


    private final AuthService authService;
    private final CompanyService companyService;

    private final JwtTokenManager jwtTokenManager;


    @PostMapping(REGISTERWEBSITEMANAGER)
    @Operation(summary = "Website manager kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerWebsiteManager(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok(authService.registerWebsiteManager(dto));
    }

    @PostMapping(REGISTERCOMPANYDIRECTOR)
    @Operation(summary = "Company director kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerCompanyDirector(@RequestBody @Valid RegisterCompanyDirectorRequestDto dto){
        return  ResponseEntity.ok(authService.registerCompanyDirector(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto){
        return  ResponseEntity.ok(authService.login(dto));
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

    @PostMapping("/registeremployee")
    public ResponseEntity<RegisterResponseDto> registerEmployee(RegisterEmployeeRequestDto dto){
        return ResponseEntity.ok(authService.registerEmployee(dto));
    }

    @GetMapping("/findallbyrole")
    public ResponseEntity<List<Auth>> findAllByRole(Roles role){
        return ResponseEntity.ok(authService.findAllByRole(role));
    }

}
