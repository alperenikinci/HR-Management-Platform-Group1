package com.bilgeadam.group1.manager;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:8091/api/v1/websitemanager",name = "websitemanager-websitemanagerprofile",decode404 = true)
public interface IWebsiteManagerManager {

}
