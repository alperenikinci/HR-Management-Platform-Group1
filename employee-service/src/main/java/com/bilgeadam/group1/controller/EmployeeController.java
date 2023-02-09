package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.response.FindAllEmployeeByBriefResponse;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import com.bilgeadam.group1.service.EmployeeProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.group1.constants.RestApi.*;

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
    public ResponseEntity<String> createEmployeeProfile(@RequestBody @Valid CreateEmployeeProfileRequest request){
        return ResponseEntity.ok(employeeProfileService.createEmployeeProfile(request));
    }

}
