package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import com.bilgeadam.group1.service.CompanyManagerProfileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.group1.constants.RestApi.*;

@RequestMapping(COMPANYMANAGER)
@RestController
@RequiredArgsConstructor
public class CompanyManagerController {

    private final CompanyManagerProfileService companyManagerService;


    @PostMapping("/registeremployee")
    @Operation(summary = "Personel kayit eden metot")
    public ResponseEntity<RegisterResponseDto> registerEmployee(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok( companyManagerService.registerEmployee(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<CompanyManagerProfile>> findAll(){
        return ResponseEntity.ok(companyManagerService.findAll());
    }


    @GetMapping(FINDALLBYSUMMARISEDINFORMATION)
    public ResponseEntity<List<SummarisedFindAllResponse>> findAllResponse(){
        return ResponseEntity.ok(companyManagerService.findAllBySummarisedInformation());
    }
}
