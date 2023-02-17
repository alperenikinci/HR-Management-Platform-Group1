package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.request.PermissionRequestDto;
import com.bilgeadam.group1.dto.request.ProfileUpdateRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.FindAllEmployeeByBriefResponse;
import com.bilgeadam.group1.dto.response.PermissionResponseDto;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.Advance;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.repository.entity.Expenditure;
import com.bilgeadam.group1.repository.entity.Permission;
import com.bilgeadam.group1.service.EmployeeProfileService;
import com.bilgeadam.group1.service.PermissionService;
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
    private final PermissionService permissionService;

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

    @GetMapping("/showexpenditures")
    public ResponseEntity<List<Expenditure>> showExpendituresByEmployeeId(Long id){
        return ResponseEntity.ok(employeeProfileService.showExpendituresByEmployeeId(id));
    }

    @GetMapping("/showadvances")
    public ResponseEntity<List<Advance>> showAdvancesByEmployeeId(Long id){
        return ResponseEntity.ok(employeeProfileService.showAdvancesByEmployeeId(id));
    }

    @GetMapping("/showpermissions")
    public ResponseEntity<List<Permission>> showPermissionsByEmployeeId(Long id){
        return ResponseEntity.ok(employeeProfileService.showPermissionsByEmployeeId(id));
    }


}
