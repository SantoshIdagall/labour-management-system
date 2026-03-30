package com.labourmanagement.labourmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourmanagement.labourmanagement.entity.Admin;
import com.labourmanagement.labourmanagement.repository.AdminRepository;
import com.labourmanagement.labourmanagement.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	
	 @Autowired
	    private AdminRepository repo;

	    @Override
	    public Admin createAdmin(Admin admin) {

	        if (repo.existsByEmail(admin.getEmail()))
	            throw new RuntimeException("Email already exists!");

	        if (repo.existsByUserName(admin.getUserName()))
	            throw new RuntimeException("Username already exists!");

	        return repo.save(admin);
	    }

	    @Override
	    public Admin updateAdmin(Long id, Admin admin) {
	        Admin existing = repo.findById(id).orElse(null);
	        if (existing == null) return null;

	        existing.setEmail(admin.getEmail());
	        existing.setPassword(admin.getPassword());
	        existing.setUserName(admin.getUserName());

	        return repo.save(existing);
	    }

	    @Override
	    public List<Admin> getAllAdmins() {
	        return repo.findAll();
	    }

	    @Override
	    public Admin getAdminById(Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteAdmin(Long id) {
	        repo.deleteById(id);
	    }

	    @Override
	    public Admin login(String email, String password) {
	        Admin admin = repo.findByEmail(email);

	        if (admin == null) return null;

	        if (!admin.getPassword().equals(password)) return null;

	        return admin;
	    }
}
