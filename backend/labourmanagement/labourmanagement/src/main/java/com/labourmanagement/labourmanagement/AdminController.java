package com.labourmanagement.labourmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labourmanagement.labourmanagement.entity.Admin;
import com.labourmanagement.labourmanagement.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")


public class AdminController {

    @Autowired
    private AdminService service;

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Admin admin) {
        try {
            return ResponseEntity.ok(service.createAdmin(admin));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Admin admin) {
        Admin updated = service.updateAdmin(id, admin);

        if (updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAll() {
        return ResponseEntity.ok(service.getAllAdmins());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Admin admin = service.getAdminById(id);

        if (admin == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(admin);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Admin admin = service.getAdminById(id);

        if (admin == null)
            return ResponseEntity.notFound().build();

        service.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully.");
    }

    // LOGIN
    
    
    
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        Admin loggedIn = service.login(admin.getEmail(), admin.getPassword());

        if (loggedIn == null)
            return ResponseEntity.badRequest().body("Invalid email or password.");

        return ResponseEntity.ok(loggedIn);
    }
}