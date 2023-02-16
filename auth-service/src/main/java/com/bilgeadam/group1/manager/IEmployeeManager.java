package com.bilgeadam.group1.manager;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.request.websitemanager.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.UpdateTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.Optional;

import static com.bilgeadam.group1.constants.RestApi.CREATE;
import static com.bilgeadam.group1.constants.RestApi.UPDATETOKEN;

@FeignClient(url = "http://localhost:8093/api/v1/employee",name = "employee-employeeprofile",decode404 = true)

public interface IEmployeeManager {

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createEmployeeProfile(@RequestBody @Valid CreateEmployeeProfileRequest request);
    @PutMapping(UPDATETOKEN)
    public ResponseEntity<Optional<UpdateTokenResponseDto>> updateTokenByEmail(@RequestBody UpdateTokenRequestDto dto);
}
