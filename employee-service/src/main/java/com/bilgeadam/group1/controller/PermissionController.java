package com.bilgeadam.group1.controller;

import com.bilgeadam.group1.dto.request.AdvanceStatusChangeRequest;
import com.bilgeadam.group1.dto.request.PermissionRequestDto;
import com.bilgeadam.group1.dto.request.PermissionStatusChangeRequest;
import com.bilgeadam.group1.dto.response.PermissionResponseDto;
import com.bilgeadam.group1.repository.entity.Permission;
import com.bilgeadam.group1.service.EmployeeProfileService;
import com.bilgeadam.group1.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {
    private final EmployeeProfileService employeeProfileService;
    private final PermissionService permissionService;


    @PostMapping("/create")
    public ResponseEntity<PermissionResponseDto> create(@RequestBody PermissionRequestDto dto){
        return ResponseEntity.ok(permissionService.createPermission(dto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Permission>> findAll(){
        return ResponseEntity.ok(permissionService.findAll());
    }

    @GetMapping("/findAllByEmployeeId")
    public ResponseEntity<List<Permission>> findAllByEmployeeId(Long id){
        return ResponseEntity.ok(permissionService.findAllByEmployeeId(id));
    }

    @PostMapping("/changestatus")
    public ResponseEntity<Boolean> changeStatus(PermissionStatusChangeRequest request){
        return ResponseEntity.ok(permissionService.changeStatus(request));
    }
}
