package com.bilgeadam.group1.service;

import com.bilgeadam.group1.repository.IWebsiteManagerRepository;
import com.bilgeadam.group1.repository.entity.WebsiteManager;
import com.bilgeadam.group1.utility.JwtTokenManager;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class WebsiteManagerService extends ServiceManager<WebsiteManager,Long > {

    private final IWebsiteManagerRepository websiteManagerRepository;
    private final JwtTokenManager jwtTokenManager;


    public WebsiteManagerService(IWebsiteManagerRepository websiteManagerRepository, CacheManager cacheManager, JwtTokenManager jwtTokenManager) {
        super(websiteManagerRepository);
        this.websiteManagerRepository=websiteManagerRepository;
        this.jwtTokenManager = jwtTokenManager;
    }
}
