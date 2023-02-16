package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.service.EmployeeProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.group1.constants.RestApi.*;
import static com.bilgeadam.group1.constants.RestApi.UPDATETOKEN;

@RestController
@RequestMapping(EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeProfileService employeeProfileService;

    @GetMapping(FINDALLEMPLOYEES)
    public ResponseEntity<List<EmployeeProfile>> findAllEmployees(){
        return ResponseEntity.ok(employeeProfileService.findAll());
    }

    @GetMapping(FINDEMPLOYEESBYBRIEFINFORMATION)
    public ResponseEntity<List<FindAllEmployeeByBriefResponse>> findAllEmployeesByBriefInfo(){
        return ResponseEntity.ok(employeeProfileService.findAllWithBriefInformation());
    }

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createEmployeeProfile(@RequestBody @Valid CreateEmployeeProfileRequest request){
        return ResponseEntity.ok(employeeProfileService.createEmployeeProfile(request));
    }

    @PutMapping(UPDATETOKEN)
    public ResponseEntity<Optional<UpdateTokenResponseDto>> updateTokenByEmail(@RequestBody UpdateTokenRequestDto dto){
        return ResponseEntity.ok(employeeProfileService.updateTokenByEmail(dto));
    }

    @GetMapping(FINDBYEMAIL)
    public ResponseEntity<Optional<EmployeeProfile>> findOptionalByEmail(String email){
        return ResponseEntity.ok(employeeProfileService.findByEmail(email));
    }
    @GetMapping(FINDBYTOKEN)
    public ResponseEntity<Optional<EmployeeProfile>> findOptionalByToken(String token){
        return ResponseEntity.ok(employeeProfileService.findOptionalByToken(token));
    }

    @PutMapping(UPDATEBYTOKEN)
    public ResponseEntity<Optional<ProfileUpdateResponse>> updateByToken(ProfileUpdateRequest request){
        return ResponseEntity.ok(employeeProfileService.updateProfileByToken(request));
    }
}
