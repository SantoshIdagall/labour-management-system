package com.labourmanagement.labourmanagement.service;

import java.util.List;

import com.labourmanagement.labourmanagement.entity.Admin;

public interface AdminService {

    Admin createAdmin(Admin admin);

    Admin updateAdmin(Long id, Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    void deleteAdmin(Long id);

    Admin login(String email, String password);
	
}
