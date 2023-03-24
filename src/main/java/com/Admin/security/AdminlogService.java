package com.Admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.Admin.model.Admin;
import com.Admin.repository.AdminRepository;



@Service
public class AdminlogService implements UserDetailsService {
	@Autowired
    AdminRepository adminRepository;
//    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Admin admin = adminRepository.findById(username).get();
        if(admin == null) {
            return null;
        }
        
        return new Adminlog(admin);
    }
    
}

