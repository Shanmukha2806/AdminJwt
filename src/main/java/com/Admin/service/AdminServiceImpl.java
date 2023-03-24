package com.Admin.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.Admin.model.Admin;
import com.Admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	private AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	//@Override
//	public CommandLineRunner initializeDatabase() {
//		// TODO Auto-generated method stub
//		return args -> {
//			Admin admin1 = new Admin("admin@gmail.com","admin");
//			
//			adminRepository.save(admin1);
//			
//		};
//	}
}

