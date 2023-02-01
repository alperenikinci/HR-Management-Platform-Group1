package com.bilgeadam.group1.controller;


import com.bilgeadam.group1.dto.request.LoginRequestDto;
import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.LoginResponseDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.service.WebsiteManagerService;
import com.bilgeadam.group1.utility.JwtTokenManager;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.bilgeadam.group1.constants.RestApi.*;
@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final WebsiteManagerService websiteManagerService;
    private final JwtTokenManager jwtTokenManager;


    @PostMapping(REGISTERWEBSITEMANAGER)
    @Operation(summary = "Website manager kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerWebsiteManager(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok(websiteManagerService.registerWebsiteManager(dto));
    }

    @PostMapping(REGISTERGENERALMANAGER)
    @Operation(summary = "General Manager kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerGeneralManager(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok( websiteManagerService.registerWebsiteManager(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto){
        return  ResponseEntity.ok(websiteManagerService.login(dto));
    }
}
