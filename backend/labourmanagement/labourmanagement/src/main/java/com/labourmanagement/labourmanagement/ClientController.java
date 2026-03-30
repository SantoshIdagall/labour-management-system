package com.labourmanagement.labourmanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labourmanagement.labourmanagement.entity.Client;
import com.labourmanagement.labourmanagement.service.ClientService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping("/register")
    public ResponseEntity<Client> register(@RequestBody Client client) {
        Client saved = service.register(client);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Client client = service.getById(id);
        if (client == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(client);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Client client) {
        Client updated = service.update(id, client);
        if (updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }
    
    // ✅ DELETE BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean removed = service.delete(id);

        if (!removed)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok("Client deleted successfully");
    }

    // ✅ DELETE ALL
    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok("All clients deleted successfully");
    }
}
