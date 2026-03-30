package com.labourmanagement.labourmanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labourmanagement.labourmanagement.entity.Labour;
import com.labourmanagement.labourmanagement.service.LabourService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/labours")
public class LabourController {

    @Autowired
    private LabourService service;

    @PostMapping("/register")
    public ResponseEntity<Labour> register(@RequestBody Labour labour) {
        Labour saved = service.register(labour);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Labour>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Labour labour = service.getById(id);
        if (labour == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(labour);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Labour labour = service.getById(id);

        if (labour == null)
            return ResponseEntity.notFound().build();

        service.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> delete() {
    	service.deleteall();
        return ResponseEntity.ok("Deleted Successfully");
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Labour labour) {
        Labour updated = service.update(id, labour);
        if (updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }
}

