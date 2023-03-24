package com.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.jwt.JwtUtils;
import com.Admin.model.Admin;
import com.Admin.service.AdminService;


@CrossOrigin(origins ="http://localhost:3000/" )
@RestController
@RequestMapping("/api")
public class Controller {
	private AdminService adminService;

	@Autowired
	AuthenticationManager authmanage;

	@Autowired
	JwtUtils jwtUtils;

	public Controller(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
				String pass = admin.getAdmin_password();
				admin.setAdmin_password(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.CREATED);

	}
	@PostMapping("/signin")
	public String authDoctor(@RequestBody Admin admin){
		try {
			@SuppressWarnings("unused")

			Authentication authtoken=  authmanage.authenticate(
					new UsernamePasswordAuthenticationToken(admin.getAdmin_username(),admin.getAdmin_password()));
			String token = jwtUtils.generateToken(admin.getAdmin_username().toString());
			return token;

		} catch (Exception e) {
			// TODO: handle exception
			return "Login Failed";
		}
	}
}
