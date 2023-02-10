package com.bilgeadam.group1.manager;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.bilgeadam.group1.constants.RestApi.CREATE;

@FeignClient(url = "http://localhost:8093/api/v1/employee",name = "employee-employeeprofile",decode404 = true)

public interface IEmployeeManager {

    @PostMapping(CREATE)
    public ResponseEntity<String> createEmployeeProfile(@RequestBody @Valid CreateEmployeeProfileRequest request);
}
