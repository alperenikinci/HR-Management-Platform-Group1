package com.bilgeadam.group1.manager;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:8092/api/v1/companydirector",name = "companydirector-companydirectorprofile",decode404 = true)
public interface ICompanyDirectorManager {

}
