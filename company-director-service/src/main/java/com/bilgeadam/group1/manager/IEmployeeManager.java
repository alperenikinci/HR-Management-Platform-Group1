package com.bilgeadam.group1.manager;

import com.bilgeadam.group1.dto.request.NewCreateEmployeRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.bilgeadam.group1.constants.RestApi.CREATE;

@FeignClient(url = "${myapplication.feign.employee.profile}",name = "employee-employeeprofile",decode404 = true)
public interface IEmployeeManager {

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createEmployee(@RequestBody NewCreateEmployeRequestDto dto);
}
