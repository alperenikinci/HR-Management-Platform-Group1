package com.bilgeadam.group1.config.security;

import com.bilgeadam.group1.repository.entity.WebsiteManager;
import com.bilgeadam.group1.service.WebsiteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    private WebsiteManagerService websiteManagerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserById(Long id) {
        Optional<WebsiteManager> websiteManager = websiteManagerService.findById(id);
        if(websiteManager.isPresent()){
            List<GrantedAuthority> authorityList = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(websiteManager.get().getRole().toString()));

            return User.builder()
                    .username(websiteManager.get().getEmail())
                    .password("")
                    .accountExpired(false)
                    .accountLocked(false)
                    .authorities(authorityList)
                    .build();
        }
        return null;
    }
}
