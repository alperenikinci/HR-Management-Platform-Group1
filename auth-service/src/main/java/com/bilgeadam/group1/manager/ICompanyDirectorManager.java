package com.bilgeadam.group1.manager;

import com.bilgeadam.group1.dto.request.companydirector.CompanyManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.UpdateTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static com.bilgeadam.group1.constants.RestApi.CREATE;
import static com.bilgeadam.group1.constants.RestApi.UPDATETOKEN;

@FeignClient(url = "http://localhost:8092/api/v1/companydirector",name = "companydirector-companydirectorprofile",decode404 = true)
public interface ICompanyDirectorManager {

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createCompanyManagerProfile (@RequestBody CompanyManagerProfileCreateRequestDto dto);

    @PutMapping(UPDATETOKEN)
    public ResponseEntity<Optional<UpdateTokenResponseDto>> updateTokenByEmail(@RequestBody UpdateTokenRequestDto dto);

}
