package com.Admin.service;

import org.springframework.boot.CommandLineRunner;

import com.Admin.model.Admin;

public interface AdminService {
	Admin addAdmin(Admin admin);
	//CommandLineRunner initializeDatabase();
}
